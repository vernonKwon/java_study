package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> a = new HashMap<>();

        a.put("벨류" , "키");
        a.put("value", "key");

        System.out.println(a.get("value"));
	// write your code here
    }
}
