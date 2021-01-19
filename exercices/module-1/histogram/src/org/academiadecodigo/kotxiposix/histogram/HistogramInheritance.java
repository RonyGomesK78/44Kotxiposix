package org.academiadecodigo.kotxiposix.histogram;

import java.util.HashMap;
import java.util.Iterator;

public class HistogramInheritance extends HashMap<String, Integer> implements Iterable<String> {

    public HistogramInheritance(String sentence) {

        String[] words = sentence.split(" ");

        for (String word : words) {

            if (containsKey(word)){

                put(word, get(word) + 1);
            }
            else {

                put(word, 1);
            }
        }
    }

    @Override
    public Iterator<String> iterator() {

        return keySet().iterator();
    }
}
