package org.academiadecodigo.kotxiposix.exceptions;

public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager(5);
        File file;

        fileManager.login();

        try {

            fileManager.createFile("readme");
            fileManager.createFile("someStuffs");

        } catch (NotEnoughPermissionsException e) {

            System.out.println(e);

        } catch (NotEnoughSpaceException e) {

            System.out.println(e);
        }

        fileManager.logout();

        try {

            file = fileManager.getFile("someStuffs");
            System.out.println(file.getFileName());

            file = fileManager.getFile("asd");
            System.out.println(file.getFileName());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
