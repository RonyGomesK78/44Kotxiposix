package org.academiadecodigo.kotxiposix.histogram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Histogram implements Iterable<String>{

    private Map<String, Integer> hashMap;

    @Override
    public Iterator<String> iterator() {

        return hashMap.keySet().iterator();
    }

    public Histogram(String sentence){

        hashMap = new HashMap<>();

        String[] words = splitSentence(sentence);

        for (String word : words) {

            if(hashMap.containsKey(word)){

                hashMap.put(word, hashMap.get(word) + 1);
            }
            else {

                hashMap.put(word, 1);
            }
        }
    }

    public int getValue(String word){

        return hashMap.get(word);
    }
    public String[] splitSentence(String sentence){

        return sentence.split(" ");
    }


}
