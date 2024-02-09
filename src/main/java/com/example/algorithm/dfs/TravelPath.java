package com.example.algorithm.dfs;

import java.util.*;

public class TravelPath {

    private static ArrayList<String>[] airportArray;
    private static List<String> answerList = new ArrayList<>();
    private static HashMap<String, Integer> ticketIndexMap;
    private static boolean isAscending = true;

    public static void main(String[] args) {
        /*String[][] tickets = new String[3][2];
        tickets[0][0] = "ICN";
        tickets[0][1] = "JFK";
        tickets[1][0] = "HND";
        tickets[1][1] = "IAD";
        tickets[2][0] = "JFK";
        tickets[2][1] = "HND";

        System.out.println(solution(tickets));*/
/*
        String[][] tickets1 = new String[5][2];
        tickets1[0][0] = "ICN";
        tickets1[0][1] = "SFO";
        tickets1[1][0] = "ICN";
        tickets1[1][1] = "ATL";
        tickets1[2][0] = "SFO";
        tickets1[2][1] = "ATL";
        tickets1[3][0] = "ATL";
        tickets1[3][1] = "ICN";
        tickets1[4][0] = "ATL";
        tickets1[4][1] = "SFO";

        System.out.println(solution(tickets1));*/

        String[][] tickets2 = new String[5][2];
        tickets2[0][0] = "ICN";
        tickets2[0][1] = "B";
        tickets2[1][0] = "B";
        tickets2[1][1] = "ICN";
        tickets2[2][0] = "ICN";
        tickets2[2][1] = "A";
        tickets2[3][0] = "A";
        tickets2[3][1] = "D";
        tickets2[4][0] = "D";
        tickets2[4][1] = "A";
        System.out.println(solution(tickets2));
    }

    public static List<String> solution(String[][] tickets) {
        ticketIndexMap = new HashMap<>();

        int ticketMapCount = 0;
        for (String[] ticket: tickets) {
            if (ticketIndexMap.containsKey(ticket[0])) continue;
            ticketIndexMap.put(ticket[0], ticketMapCount);
            ticketMapCount++;
        }

        for (String[] ticket: tickets) {
            if (ticketIndexMap.containsKey(ticket[1])) continue;
            ticketIndexMap.put(ticket[1], ticketMapCount);
            ticketMapCount++;
        }

        airportArray = new ArrayList[ticketMapCount];

        ticketIndexMap.entrySet().forEach(map -> airportArray[map.getValue()] = new ArrayList<>());

        for (String[] ticket: tickets) {
            airportArray[ticketIndexMap.get(ticket[0])].add(ticket[1]);
            if (isAscending) Collections.sort(airportArray[ticketIndexMap.get(ticket[0])]);
            else airportArray[ticketIndexMap.get(ticket[0])].sort(Collections.reverseOrder());
        }

        answerList.add("ICN");
        dfs("ICN");

        if (answerList.size() == tickets.length + 1) {
            return answerList;
        } else {
            isAscending = false;
            answerList = new ArrayList<>();
            return solution(tickets);
        }
    }

    private static void dfs(String start) {
        List<String> airport = airportArray[ticketIndexMap.get(start)];
        if (airport.isEmpty()) return;
        String departure = airport.get(0);
        answerList.add(departure);
        airport.remove(0);

        dfs(departure);
    }
}
