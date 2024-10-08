package com.webstartrek.music;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Named
@SessionScoped
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<ShoppingCartLine> lines = new ArrayList<>();

    private int totalQuantity = 0;

    private BigDecimal totalAmount = BigDecimal.ZERO;

    public List<ShoppingCartLine> getLines() {
        return lines;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void addProduct(Product product) {
        // Find the line for this product, increment quantity and amount if found
        for (ShoppingCartLine line : lines) {
            if (line.getProduct().getId() == product.getId()) {
                line.incrementQuantityAndAmount();
                incrementTotalQuantityAndAmount(line.getProduct().getPrice());
                return;
            }
        }

        // No line for this product yet, add a new line
        lines.add(new ShoppingCartLine(product));
        incrementTotalQuantityAndAmount(product.getPrice());
    }

    public void removeProduct(Product product) {
        Iterator<ShoppingCartLine> it = lines.iterator();
        while (it.hasNext()) {
            ShoppingCartLine line = it.next();

            // If this is the line for this product, decrement quantity and amount;
            // remove the line if the quantity has become 0
            if (line.getProduct().getId() == product.getId()) {
                if (line.decrementQuantityAndAmount()) {
                    it.remove();
                }

                decrementTotalQuantityAndAmount(product.getPrice());
            }
        }
    }

    private void incrementTotalQuantityAndAmount(BigDecimal productPrice) {
        totalQuantity++;
        totalAmount = totalAmount.add(productPrice);
    }

    private void decrementTotalQuantityAndAmount(BigDecimal productPrice) {
        totalQuantity--;
        totalAmount = totalAmount.subtract(productPrice);
    }
}
