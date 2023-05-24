package org.fog.gui.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class alaki {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> list = new ArrayList<>();
        map.put("hossein", list);
        map.get("hossein").add("111");
        System.out.println(map.get("hossein"));
    }
}
