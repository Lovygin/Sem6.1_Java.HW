package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AllContacts {

    private LinkedHashMap<String, HashSet<String>> sortedByValueLengthMap;
    private HashMap<String, HashSet<String>> allContacts = new HashMap<>();

    public void sortedByValueLength(HashMap<String, HashSet<String>> pB) {
        Comparator<Map.Entry<String, HashSet<String>>> comparator =
                Comparator.comparing(entry -> entry.getValue().size());
        sortedByValueLengthMap = pB.entrySet()
                .stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println(sortedByValueLengthMap);
    }
    public void addToGeneralPhoneBook(HashMap<String, HashSet<String>> pB){
        for (Map.Entry<String, HashSet<String>> entry : pB.entrySet()) {
            if(!allContacts.containsKey(entry.getKey())) {
                allContacts.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
