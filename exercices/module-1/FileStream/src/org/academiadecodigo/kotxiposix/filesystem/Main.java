package org.academiadecodigo.kotxiposix.filesystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        MyFileInputStream in;
        MyFileOutputStream out;

        try {

            in = new MyFileInputStream("/Users/codecadet/44kotxiposix/exercices/module-1/FileStream/hello.txt");
            //System.out.println(in.countBytesRead(new byte[1024]));
            //in.closeFile();


            out = new MyFileOutputStream("/Users/codecadet/44kotxiposix/exercices/module-1/FileStream/hellocopy.txt");

            int length;
            byte[] buffer = new byte[1024];

            while ((length = in.fetchData(buffer)) !=  -1){

                System.out.println("times");
                out.writeToFile(buffer, 0, length);
            }

            in.closeFile();
            out.closeFile();


        }catch (FileNotFoundException e){

            System.out.println("Can't found the file");

        }catch (IOException e){

            System.out.println("Error when read from the file or when close the file");

        }


    }
}
