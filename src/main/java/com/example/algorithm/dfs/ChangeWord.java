package com.example.algorithm.dfs;
/*

public class ChangeWord {

    private static boolean[] visited;
    private static int changeCount = 0;

    private static boolean changedSucceed = false;

    public static void main(String[] args) {
        String[] words = new String[6];
        words[0] = "hot";
        words[1] = "dot";
        words[2] = "dog";
        words[3] = "lot";
        words[4] = "log";
        words[5] = "cog";

        System.out.println(solution("hit", "cog", words));
    }

    private static int solution(String begin, String target, String[] words) {
        visited = new boolean[begin.length()];

        for (int i = 0; i < begin.length(); i++) {
            visited[i] = false;
        }

        dfs(begin, target, words, 0);

        if (changedSucceed) return changeCount;
        else return 0;
    }

    private static void dfs(String begin, String target, String[] words, int wordsIndex) {
        if (begin.equals(target)) {
            changedSucceed = true;
            return;
        }

        int differentCount = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != words[wordsIndex].charAt(i)) differentCount++;
        }

        for (int i = 0; i < begin.length(); i++) {
            if (visited[i]) continue;

            if (differentCount == 1) {
                changeCount++;
                visited[i] = true;
                dfs(word, target, words, wordsIndex + 1);
            }
        }


    }
}
*/
