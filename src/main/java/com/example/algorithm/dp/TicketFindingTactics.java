package com.example.algorithm.dp;

import java.util.*;

public class TicketFindingTactics {
    public static int maxGoldenTickets(String[] tickets, int roll, String[][] shop, int money) {
        // Parse ticket prices into a map for easy access
        Map<String, Integer> ticketPrices = new HashMap<>();
        for (String ticketInfo : tickets) {
            String[] parts = ticketInfo.split(" ");
            ticketPrices.put(parts[0], Integer.parseInt(parts[1]));
        }

        // Dynamic programming table to keep track of the maximum golden tickets for given money
        int[][] dp = new int[shop.length + 1][money + 1];

        // Iterate over each store state, including the initial state before any refresh
        for (int i = 0; i <= shop.length; i++) {
            for (int j = 0; j <= money; j++) {
                // Calculate maximum golden tickets without refreshing (if possible)
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j]; // Carry forward the previous state if no action is taken
                }
                // Check if it's possible to refresh the store
                if (i > 0 && j >= roll) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - roll]);
                }
                // Try purchasing tickets from the current store state
                if (i > 0) {
                    Map<String, Integer> counts = new HashMap<>();
                    for (String ticket : shop[i - 1]) {
                        int price = ticketPrices.get(ticket);
                        if (j >= price) {
                            counts.put(ticket, counts.getOrDefault(ticket, 0) + 1);
                            // Update dp for purchasing this ticket
                            dp[i][j] = Math.max(dp[i][j], dp[i][j - price] + counts.get(ticket) / 3 - (counts.get(ticket) - 1) / 3);
                        }
                    }
                }
            }
        }

        // The maximum golden tickets can be obtained is the max value in the last row
        int maxGoldenTickets = 0;
        for (int i = 0; i <= money; i++) {
            maxGoldenTickets = Math.max(maxGoldenTickets, dp[shop.length][i]);
        }

        return maxGoldenTickets;
    }

    public static void main(String[] args) {
        String[] tickets = {"A 1", "B 2", "C 5", "D 3"};
        int roll = 10;
        String[][] shop = {
                {"B", "C", "B", "C"},
                {"A", "A", "A", "B"},
                {"D", "D", "C", "D"}
        };
        int money = 30;

        System.out.println("Maximum Golden Tickets: " + maxGoldenTickets(tickets, roll, shop, money));
    }
}