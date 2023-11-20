package com.example.algorithm.dfs;

import java.util.*;

public class TravelPath {

    private static ArrayList<String>[] airportArray;
    private static boolean[] visited;
    private static final List<String> answerList = new ArrayList<>();
    private static HashMap<String, Integer> ticketIndexMap;


    public static void main(String[] args) {
        /*String[][] tickets = new String[3][2];
        tickets[0][0] = "ICN";
        tickets[0][1] = "JFK";
        tickets[1][0] = "HND";
        tickets[1][1] = "IAD";
        tickets[2][0] = "JFK";
        tickets[2][1] = "HND";

        System.out.println(solution(tickets));*/

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

        System.out.println(solution(tickets1));
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
        visited = new boolean[tickets.length];

        ticketIndexMap.entrySet().forEach(map -> {
            airportArray[map.getValue()] = new ArrayList<>();
        });

        for (int i = 0; i < tickets.length; i++) {
            visited[i] = false;
        }

        answerList.add(tickets[0][0]);

        for (String[] ticket: tickets) {
            airportArray[ticketIndexMap.get(ticket[0])].add(ticket[1]);
            Collections.sort(airportArray[ticketIndexMap.get(ticket[0])]);
        }

        dfs(0, tickets);

        return answerList;
    }

    private static void dfs(int index, String[][] tickets) {
        boolean isAllVisited = true;
        for (boolean visit: visited) {
            if (!visit) {
                isAllVisited = false;
                break;
            }
        }

        if (isAllVisited) return;
        visited[index] = true;

        Integer airportIndex = ticketIndexMap.get(tickets[index][0]);

        ArrayList<String> airport = airportArray[airportIndex];
        if (airport.isEmpty()) return;
        String nextPath = airport.get(0);

        answerList.add(nextPath);

        dfs(++index, tickets);
    }
}
