package com.cehernani.exceptions;

/*
    Types of Exceptions:
        1) Checked      -> Exception        : compile-time
        2) Unchecked    -> RuntimeException : runtime

    Java Exception Class Hierarchy:
        java.lang.Object
            java.lang.Throwable
                java.lang.Exception
                    java.lang.RuntimeException

    https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
