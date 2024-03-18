package com.example.algorithm.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    private static final Map<String, Integer> vacCountMap = new HashMap<>();
    private static final Map<String, Integer> vacMinMap = new HashMap<>();
    private static final Map<String, Integer> vacMaxMap = new HashMap<>();
    private static final Map<String, String> vacResultMap = new HashMap<>();

    public static void main(String[] args) {
        String[] vac = new String[3];
        String[] peo = new String[5];

        vac[0] = "PIZER 3 20 99";
        vac[1] = "ASTRA 1 9 55";
        vac[2] = "YANSEN 10000 22 49";

        peo[0] = "susan 50 ASTRA YANSEN PIZER";
        peo[1] = "kevin 55 ASTRA";
        peo[2] = "luka 60 PIZER ASTRA";
        peo[3] = "erica 20 YANSEN PIZER ASTRA";
        peo[4] = "roy 20 PIZER";

        initVac(vac);

        Arrays.sort(peo, (o1, o2) -> {
            String[] o1Array = o1.split(" ");
            String[] o2Array = o2.split(" ");
            int o1Count = Integer.parseInt(o1Array[1]);
            int o2Count = Integer.parseInt(o2Array[1]);
            if (o1Count == o2Count) {
                return 0;
            }
            return o2Count - o1Count;
        });

        for (String s : peo) {
            String[] sArray = s.split(" ");
            int age = Integer.parseInt(sArray[1]);
            for (int i = 2; i < sArray.length; i++) {
                if (vacCountMap.get(sArray[i]) > 0) {
                    if (vacMinMap.get(sArray[i]) <= age && age <= vacMaxMap.get(sArray[i])) {
                        vacCountMap.put(sArray[i], vacCountMap.get(sArray[i]) - 1);
                        vacResultMap.put(sArray[i], String.format("%s %s", vacResultMap.get(sArray[i]), sArray[0]));
                        break;
                    }
                }
            }
        }

        String[] result = vacResultMap
                .keySet()
                .stream()
                .filter(key -> !vacResultMap.get(key).isEmpty())
                .map(key -> {
                    String[] s = vacResultMap.get(key).trim().split(" ");
                    Arrays.sort(s);
                    return String.format("%s %s", key, Arrays.toString(s)
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
                })
                .toArray(String[]::new);

        Arrays.sort(result, (o1, o2) -> {
            String[] o1Array = o1.split(" ");
            String[] o2Array = o2.split(" ");
            return o1Array[0].compareTo(o2Array[0]);
        });

        Arrays.stream(result).forEach(System.out::println);
    }

    private static void initVac(String[] vac) {
        for (String s : vac) {
            String[] sArray = s.split(" ");
            vacCountMap.put(sArray[0], Integer.parseInt(sArray[1]));
            vacMinMap.put(sArray[0], Integer.parseInt(sArray[2]));
            vacMaxMap.put(sArray[0], Integer.parseInt(sArray[3]));
            vacResultMap.put(sArray[0], "");
        }
    }
}
