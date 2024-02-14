package org.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class AddContact {
    public HashMap<String, HashSet<String>> addContact (HashMap<String, HashSet<String>> pB, String name, String num){
        pB.putIfAbsent(name, new HashSet<>(Arrays.asList(num)));
        pB.get(name).add(num);
        return pB;
    }

}
