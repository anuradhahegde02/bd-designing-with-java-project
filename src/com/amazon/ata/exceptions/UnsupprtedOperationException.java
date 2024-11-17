package com.amazon.ata.exceptions;

public class UnsupprtedOperationException extends Exception {

    /**
     * Exception with no message or cause.
     */
    public UnsupprtedOperationException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     *
     * @param message A descriptive message for this exception.
     */
    public UnsupprtedOperationException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     *
     * @param cause The original throwable resulting in this exception.
     */
    public UnsupprtedOperationException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     *
     * @param message A descriptive message for this exception.
     * @param cause   The original throwable resulting in this exception.
     */
    public UnsupprtedOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
