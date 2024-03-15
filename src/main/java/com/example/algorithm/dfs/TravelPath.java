package com.example.algorithm.dfs;

import java.util.*;

class TravelPath {

    private final Map<String, List<String>> graph = new HashMap<>();
    private final Stack<String> answer = new Stack<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                graph.put(ticket[0], list);
            } else {
                List<String> list = graph.get(ticket[0]);
                list.add(ticket[1]);
                Collections.sort(list);
            }
        }

        dfs("ICN");

        int size = answer.size();
        String[] answerArr = new String[size];

        for (int i = 0; i < size; i++) {
            answerArr[i] = answer.pop();
        }

        return answerArr;
    }

    private void dfs(String airport) {
        List<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String first = destinations.get(0);
            destinations.remove(0);
            dfs(first);
        }

        answer.add(airport);
    }
}