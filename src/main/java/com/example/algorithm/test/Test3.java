package com.example.algorithm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {

    public static void main(String[] args) {
        String[] approved = new String[3];
        String[] spams = new String[1];
        String[] calls = new String [8];
        int k = 2;

        approved[0] = "123-4567";
        approved[1] = "451-2314";
        approved[2] = "015-1643";
        spams[0] = "111-1111";

        calls[0] = "123-4567";
        calls[1] = "000-0022";
        calls[2] = "015-1643";
        calls[3] = "000-0022";
        calls[4] = "111-1111";
        calls[5] = "000-0022";
        calls[6] = "111-1111";
        calls[7] = "111-1111";

        Map<String, String> approvedMap = new HashMap<>();
        for (String s : approved) {
            approvedMap.put(s, "");
        }

        Map<String, String> spamMap = new HashMap<>();
        for (String s : spams) {
            spamMap.put(s, "");
        }

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> callsWithoutApproved = new HashMap<>();

        for (String call : calls) {
            if (approvedMap.containsKey(call)) {
                result.add(0);
            } else if (spamMap.containsKey(call)) {
                result.add(1);
            } else {
                if (callsWithoutApproved.containsKey(call)) {
                    callsWithoutApproved.put(call, callsWithoutApproved.get(call) + 1);
                } else {
                    callsWithoutApproved.put(call, 1);
                }

                if (callsWithoutApproved.get(call) <= k) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }

        System.out.println(result);
    }
}
