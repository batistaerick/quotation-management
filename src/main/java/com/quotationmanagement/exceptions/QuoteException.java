package com.quotationmanagement.exceptions;

public class QuoteException extends RuntimeException {

    public QuoteException(String msg) {
        super(msg);
    }

    public QuoteException(Throwable throwable) {
        super(throwable);
    }

}