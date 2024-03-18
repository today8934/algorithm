package com.example.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        int n = 50;
        int[][] battery = new int[3][2];
        battery[0][0] = 10;
        battery[0][1] = 100000;
        battery[1][0] = 4;
        battery[1][1] = 35000;
        battery[2][0] = 1;
        battery[2][1] = 15000;
        //battery[3][0] = 2;
        //battery[3][1] = 32000;

        Arrays.sort(battery, Comparator.comparingInt(o -> o[1] / o[0]));
        int remaining = n%battery[0][0];
        int price = (n/battery[0][0])*battery[0][1];


        List<Integer> remainPriceList = new ArrayList<>();
        List<int[]> dpList = new ArrayList<>();
        for (int i = 0; i < battery.length; i++) {
            if (battery[i][0] >= remaining) remainPriceList.add(battery[i][1]);
            else dpList.add(battery[i]);
        }

        String[][] dp = new String[remaining][(int) Math.pow(dpList.size(), remaining)];
        for (int i = 0; i < remaining; i++) {
            for (int j = 0; j < (int) Math.pow(dpList.size(), i + 1); j++) {
                dp[i][j] = String.format("%s-%s", dpList.get(j%dpList.size())[0], dpList.get(j%dpList.size())[1]);
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == null) continue;
                String root = dp[i - 1][j/dpList.size()];
                int rootCount = Integer.parseInt(root.split("-")[0]);
                if (rootCount >= remaining) {
                    dp[i][j] = root;
                    continue;
                }
                int rootPrice = Integer.parseInt(root.split("-")[1]);
                int dpCount = Integer.parseInt(dp[i][j].split("-")[0]);
                int dpPrice = Integer.parseInt(dp[i][j].split("-")[1]);
                dp[i][j] = String.format("%s-%s", rootCount + dpCount, rootPrice + dpPrice);
                dp[i - 1][j/dpList.size()] = null;
            }
        }


        for (int i = 0; i < dp[0].length; i++) {
            remainPriceList.add(Integer.parseInt(dp[dp.length - 1][i].split("-")[1]));
        }

        System.out.println(remainPriceList.stream().min(Integer::compareTo).get() + price);
    }
}
