package org.academiadecodigo.kotxiposix.exceptions;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException(){

        super("Not enough space to create a new file");
    }
}
