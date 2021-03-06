package com.epam.internetshop.controllers.manager;

import java.util.ResourceBundle;

public class MessageManager {

    private static MessageManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "messages";
    public static final String LOGIN_ERROR_MESSAGE = "LOGIN_ERROR_MESSAGE";
    public static final String LOGIN_TAKEN_ERROR_MESSAGE = "LOGIN_TAKEN_ERROR_MESSAGE";
    public static final String REGISTER_ERROR_MESSAGE = "REGISTER_ERROR_MESSAGE";
    public static final String SERVLET_EXCEPTION_ERROR_MESSAGE = "SERVLET_EXCEPTION_ERROR_MESSAGE";
    public static final String IO_EXCEPTION_ERROR_MESSAGE = "IO_EXCEPTION_ERROR_MESSAGE";
    public static final String BUY_SUCCESS_MESSAGE = "BUY_SUCCESS_MESSAGE";

    public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
