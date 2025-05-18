package com.example.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * Easy
 * Topics
 * Companies
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> magazineMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            String s = String.valueOf(c);
            if (magazineMap.containsKey(s)) {
                magazineMap.put(s, magazineMap.get(s) + 1);
            } else {
                magazineMap.put(s, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            String s = String.valueOf(c);
            if (magazineMap.containsKey(s)) {
                if (magazineMap.get(s) > 0) {
                    magazineMap.put(s, magazineMap.get(s) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b")); // false
        System.out.println(ransomNote.canConstruct("aa", "ab")); // false
        System.out.println(ransomNote.canConstruct("aa", "aab")); // true
    }
}
