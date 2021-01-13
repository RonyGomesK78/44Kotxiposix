package org.academiadecodigo.kotxiposix.exceptions;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {

        super("Not enough permissions to create a file");
    }
}
