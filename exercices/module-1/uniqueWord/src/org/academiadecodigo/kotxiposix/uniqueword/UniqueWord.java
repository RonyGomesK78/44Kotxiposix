package org.academiadecodigo.kotxiposix.uniqueword;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueWord  implements Iterable<String>{

    private Set<String> uniqueWords = new LinkedHashSet<>();

    public UniqueWord(String phrase){

        String[] words = splitToWord(phrase);

        for (String word : words) {

            uniqueWords.add(word);
        }
    }

    private String[] splitToWord(String phrase){

        return phrase.split(" ");
    }

    @Override
    public Iterator<String> iterator(){

        return uniqueWords.iterator();
    }
}
