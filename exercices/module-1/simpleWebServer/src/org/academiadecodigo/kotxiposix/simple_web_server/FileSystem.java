package org.academiadecodigo.kotxiposix.simple_web_server;

import java.io.File;

public class FileSystem {


    File file = new File("/Users/codecadet/44kotxiposix/exercices" +
            "/module-1/simpleWebServer/src/org/academiadecodigo/kotxiposix/simple_web_server/www/index.html");

    File[] files;

    public FileSystem() {

        files = new File[]{new File("/Users/codecadet/44kotxiposix/exercices" +
                "/module-1/simpleWebServer/src/org/academiadecodigo" +
                "/kotxiposix/simple_web_server/www/index.html"
        ),
                new File(
                        "/Users/codecadet/44kotxiposix/exercices" +
                                "/module-1/simpleWebServer/src/org/academiadecodigo" +
                                "/kotxiposix/simple_web_server/www/notFound.html"
                )
        };
    }

    public boolean compare(File pathname) {

        return file.compareTo(pathname) == 0;
    }
}
