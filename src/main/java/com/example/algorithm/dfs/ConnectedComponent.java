package com.example.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedComponent {
    private static ArrayList<Integer>[] nodeArray;
    private static boolean[] visitArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = bufferedReader.readLine();

        String[] firstLineArray = firstLine.split(" ");

        int nodeCount = Integer.parseInt(firstLineArray[0]);
        int edgeCount = Integer.parseInt(firstLineArray[1]);

        nodeArray = new ArrayList[nodeCount + 1];
        visitArray = new boolean[nodeCount + 1];

        for (int i = 1; i < nodeCount; i++) {
            visitArray[i] = false;
        }

        for (int i = 1; i < nodeCount + 1; i++) {
            nodeArray[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            String edge = bufferedReader.readLine();
            String[] nodes = edge.split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            nodeArray[node1].add(node2);
            nodeArray[node2].add(node1);
        }

        int count = 0;
        for (int i = 1; i < nodeCount + 1; i++) {
            if (!visitArray[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int index) {
        if (visitArray[index]) return;
        visitArray[index] = true;

        for (int i: nodeArray[index]) {
            if (!visitArray[i]) {
                dfs(i);
            }
        }
    }
}
