package org.academiadecodigo.kotxiposix.exceptions;

public class FileManager {

    private File[] files;
    private boolean isLoggedIn;

    public FileManager(int containerLength) {

        this.files = new File[containerLength];
        isLoggedIn = false;
    }

    public void login() {

        isLoggedIn = true;
    }

    public void logout() {

        if (isLoggedIn) {

            isLoggedIn = false;
        }
    }

    public File getFile(String searchFile) throws FileNotFoundException {

        for (File file : files) {

            if (file == null) {

                continue;
            }

            if (file.getFileName().equals(searchFile)) {

                return file;
            }
        }

        throw new FileNotFoundException();
    }

    public void createFile(String fileName) throws NotEnoughSpaceException, NotEnoughPermissionsException {

        if (!isLoggedIn) {

            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < files.length; i++) {

            if (files[i] == null) {

                files[i] = new File(fileName);
                System.out.println("Your file was created successfully");
                return;
            }
        }

        throw new NotEnoughSpaceException();
    }
}
