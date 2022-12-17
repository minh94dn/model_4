package com.repository;

import java.util.Map;
import java.util.TreeMap;

public class DictionaryRepository {
    private static Map<String, String> map = new TreeMap<>();

    static {
        map.put("apple", "Quả Táo");
        map.put("banana", "Quả Chuối");
        map.put("orange", "Quả Cam");
        map.put("mango", "Quả Xoài");
        map.put("fruit", "Trái Cây");
    }

    public String wordTest(String word) {
        for (String e : map.keySet()) {
            if (e.equals(word)) {
                return map.get(e);
            }
        }
        return "Không tìm thấy từ này trong từ điển.";
    }
}
