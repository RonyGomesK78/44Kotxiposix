package org.academiadecodigo.kotxiposix.filesystem;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.security.auth.login.AccountLockedException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputStream {

    private FileOutputStream fileOutputStream;

    public MyFileOutputStream(String path)throws FileNotFoundException {

        this.fileOutputStream = new FileOutputStream(path);
    }

    public void writeToFile(String sentence) throws IOException {

        fileOutputStream.write(sentence.getBytes());
    }

    public void writeToFile(byte[] b, int off, int len) throws IOException {

        fileOutputStream.write(b, off, len);
    }

    public void closeFile() throws IOException {

        fileOutputStream.close();
    }

}
