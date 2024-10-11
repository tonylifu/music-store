package com.webstartrek.music.checkout;

import com.webstartrek.music.ShoppingCart;
import com.webstartrek.music.models.User;
import com.webstartrek.music.UserManager;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Named
@FlowScoped("checkout")
public class Checkout implements Serializable {

    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @Size(min = 1, max = 30, message = "Please enter a name.")
    private String shippingName;

    @Getter
    @Setter
    @Size(min = 1, max = 30, message = "Please enter an address.")
    private String shippingAddress;

    @Getter
    @Setter
    @Size(min = 1, max = 30, message = "Please enter a city.")
    private String shippingCity;

    @Getter
    @Setter
    @Size(min = 1, max = 30, message = "Please enter a name.")
    private String paymentName;

    @Getter
    @Setter
    @NotNull(message = "Please select a credit card type.")
    private CreditCardType creditCardType;

    @Getter
    @Setter
    @Pattern(regexp = "[0-9]{16}", message = "Please enter a valid credit card number.")
    private String creditCardNumber;

    @Inject
    private UserManager userManager;

    @Inject
    private ShoppingCart shoppingCart;

    @Getter
    @Setter
    private boolean paymentSuccess;

    @PostConstruct
    public void initialize() {
        if (userManager.isSignedIn()) {
            User user = userManager.getCurrentUser();
            shippingName = user.getFirstName() + " " + user.getLastName();
            paymentName = shippingName;
        }
    }

    public void fulfillOrder() {
        paymentSuccess = !creditCardNumber.endsWith("00");
    }

    public String finishOrder() {
        if (paymentSuccess) {
            shoppingCart.empty();
        }

        return "finished";
    }

}