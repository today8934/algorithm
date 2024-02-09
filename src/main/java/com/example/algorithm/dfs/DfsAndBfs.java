package com.example.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DfsAndBfs {

    private static ArrayList<Integer>[] nodeArray;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int edgeCount = Integer.parseInt(firstLine[1]);
        int startNode = Integer.parseInt(firstLine[2]);

        answer = new ArrayList<>();
        nodeArray = new ArrayList[nodeCount + 1];
        visited = new boolean[nodeCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            nodeArray[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            String[] edge = bufferedReader.readLine().split(" ");

            nodeArray[Integer.parseInt(edge[0])].add(Integer.parseInt(edge[1]));
            nodeArray[Integer.parseInt(edge[1])].add(Integer.parseInt(edge[0]));
        }

        for (int i = 0; i < edgeCount; i++) {
            Collections.sort(nodeArray[i]);
            visited[i] = false;
        }

        dfs(startNode);

        for (int i: answer) {
            System.out.println(i);
        }

        visited = new boolean[nodeCount + 1];
        answer = new ArrayList<>();

        bfs(startNode);

        for (int i: answer) {
            System.out.println(i);
        }


    }

    private static void dfs(int node) {
        answer.add(node);
        visited[node] = true;

        for (int i: nodeArray[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            answer.add(poll);
            for (int i: nodeArray[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
