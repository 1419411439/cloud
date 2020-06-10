package com.xiezy.springcloud;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put("c", "cc");
        m.put("a", "aa");
        m.put("l", "ll");
        m.put("b", "bb");

        Iterator<Map.Entry> iterator = m.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}
