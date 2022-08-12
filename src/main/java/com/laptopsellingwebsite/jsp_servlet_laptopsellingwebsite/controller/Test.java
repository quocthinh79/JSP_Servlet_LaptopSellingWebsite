package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Multimap<String, String> map = HashMultimap.create();
//        MultiMap<String, String> addBlock = new MultiValueMap<String, String>();
//        MultiMap<String, String> addBlock = new MultiKeyMap<String>();
//        Map<String, String> addBlock = new HashMap<>();
//        MultiMap<String,String> addBlock = new MultiMap<String, String>();
//        MultiMap<Integer,String> map = new MultiMap<>();
        map.put("cpu", "i9");
        map.put("hang", "MSI");
        map.put("hang", "DELL");
        map.put("hang", "DELL");
        map.put("cpu", "i5");
        map.put("hang", "HP");
        map.put("cpu", "i7");
        map.put("mau", "HP");
        map.put("series", "i7");
        map.put("GIABAN", "500000");
        map.put("GIABAN", "10000");

        map.values().removeIf(v -> v.equals("HP"));
        String joined = map.asMap()
                .entrySet()
                .stream()
                .map(e -> e.getValue()
                        .stream()
                        .map(v -> (!e.getKey().equalsIgnoreCase("GIABAN"))? (e.getKey() + " = " + "?") :
                                (e.getKey() + " IN " + map.get("GIABAN")))
                        .collect(Collectors.joining(" OR ", "(", ")")))
                .collect(Collectors.joining(" AND "));
        System.out.println(joined);
//        System.out.println(map.entries());
    }
}
