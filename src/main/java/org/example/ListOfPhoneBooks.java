package org.example; // не реализованная идея

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListOfPhoneBooks {
    private LinkedHashMap<String, LinkedHashMap<String, HashSet<String>>> lop = new LinkedHashMap<>();
    public void addNewPB(String title){

        lop.putIfAbsent(title, new LinkedHashMap<>());

    }
}
