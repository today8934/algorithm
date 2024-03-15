package com.example.algorithm.dfs;


import java.util.*;

public class ChangeWord {

    public static void main(String[] args) {
        ChangeWord solution = new ChangeWord();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result); // Expected output: 5 ("hit" -> "hot" -> "dot" -> "dog" -> "cog")
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // Convert list to set for faster checks
        if (!wordSet.contains(endWord)) return 0; // End word not in list, return 0

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1; // Initialize level to 1 to count the beginWord step

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // Iterate through all words in the current level
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return level; // Found the endWord

                // Iterate through all words, if one letter can be changed to make it equal to currentWord, add to queue
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordChars = currentWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordChars[j] = ch;
                        String transformedWord = new String(wordChars);
                        if (wordSet.contains(transformedWord)) {
                            queue.add(transformedWord);
                            wordSet.remove(transformedWord); // Remove from set to prevent re-visiting
                        }
                    }
                }
            }
            level++; // Increment level after exploring all words at the current level
        }

        return 0; // Target not found
    }
}


