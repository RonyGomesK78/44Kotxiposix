package org.academiadecodigo.kotxiposix.wordreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordReader implements Iterable<String> {

    private FileReader reader;
    private BufferedReader bReader;

    public WordReader(String file) throws FileNotFoundException {

        this.reader = new FileReader(file);
        bReader = new BufferedReader(reader);
    }

    @Override
    public Iterator<String> iterator() {

        return new WordIterator();
    }

    private class WordIterator implements Iterator<String> {

        public String readLine;

        @Override
        public boolean hasNext() {

            try {

                readLine = bReader.readLine();

                if (readLine != null){

                    return true;
                }

            } catch (IOException e) {

                System.out.println("Error when reading from the file");
            }

            return false;
        }

        @Override
        public String next() {

            if (!hasNext()) {

                return null;
            }

            return readLine;
        }

        @Override
        public void remove() {

            new UnsupportedOperationException();
        }
    }
}
