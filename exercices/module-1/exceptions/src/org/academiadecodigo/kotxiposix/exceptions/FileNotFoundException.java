package org.academiadecodigo.kotxiposix.exceptions;

public class FileNotFoundException extends  FileException{

    public FileNotFoundException(){

        super("File not found");
    }
}
