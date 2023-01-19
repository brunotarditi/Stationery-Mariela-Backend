package com.mariela.store.customExceptions;

import com.mariela.store.utils.Message;

public class MyExceptions extends RuntimeException{
    public MyExceptions(String message) {
        super(message);
    }
}
