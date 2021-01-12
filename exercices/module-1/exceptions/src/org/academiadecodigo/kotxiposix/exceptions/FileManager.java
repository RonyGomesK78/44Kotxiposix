package org.academiadecodigo.kotxiposix.exceptions;

public class FileManager {

    private File[] files;
    private boolean isLogIn;

    public FileManager(int containerLength){

        this.files = new File[ containerLength];
        isLogIn = false;
    }

    public void login(){

        isLogIn = true;
    }

    public void logout(){

        if (isLogIn){

            isLogIn = false;
        }
    }

    public File getFile(String searchFile) throws FileNotFoundException{

        for (File file : files) {

            if (file == null){

                continue;
            }

            if (file.getFileName() == searchFile){

                return file;
            }
        }

        throw new FileNotFoundException();
    }

    public void createFile(String fileName) throws NotEnoughSpaceException, NotEnoughPermissionsException{

        if (!isLogIn){

            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < files.length; i++){

            if (files[i] == null){

                files[i] = new File(fileName);
                System.out.println("Your file was created successfully");
                return;
            }
        }

        throw new NotEnoughSpaceException();
    }
}
