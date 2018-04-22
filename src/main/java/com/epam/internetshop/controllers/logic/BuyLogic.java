package com.epam.internetshop.controllers.logic;

import com.epam.internetshop.domain.Product;
import com.epam.internetshop.domain.User;
import com.epam.internetshop.services.manager.ServiceFactory;

import java.util.HashMap;

public class BuyLogic {

    public static Product getProductById(Long id) {
        return ServiceFactory.newProductService().getById(id);
    }

    public static void performPayment(User user, HashMap<Product, Long> poductCount) {
        ServiceFactory.newPaymentService().performPayment(user.getLogin(), poductCount);
    }
}
