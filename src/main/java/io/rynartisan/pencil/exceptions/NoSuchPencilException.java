package io.rynartisan.pencil.exceptions;

import java.util.NoSuchElementException;

public class NoSuchPencilException extends NoSuchElementException {

    private int pencilID;

    /**
     * Constructs a {@code NoSuchPencilException} with {@code null}
     * as its error message string.
     */
    public NoSuchPencilException() {
        super();
    }

    /**
     * Constructs a {@code NoSuchPencilException}, saving a reference
     * to the error message string {@code s} for later retrieval by the
     * {@code getMessage} method.
     *
     * @param pencilID the detail message.
     */
    public NoSuchPencilException(int pencilID) {
        super("No pencil found for ID" + pencilID);
        this.pencilID = pencilID;
    }

    public int getPencilID() {
        return pencilID;
    }

    public void setPencilID(int pencilID) {
        this.pencilID = pencilID;
    }
}
