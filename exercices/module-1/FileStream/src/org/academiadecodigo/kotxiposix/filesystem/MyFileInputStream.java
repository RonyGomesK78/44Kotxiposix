package org.academiadecodigo.kotxiposix.filesystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream {

    FileInputStream fileInputStream;


    public MyFileInputStream(String path) throws FileNotFoundException {

        fileInputStream = new FileInputStream(path);
    }


    public int countBytesRead(byte [] buffer) throws IOException {

        return fileInputStream.read(buffer);
    }

    public int fetchData(byte[] buffer) throws IOException {

        return fileInputStream.read(buffer);
    }

    public void closeFile() throws IOException {

        fileInputStream.close();
    }
}
