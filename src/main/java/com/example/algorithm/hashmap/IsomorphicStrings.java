package com.example.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                map.put(sChar, tChar);
            }

            if (reverseMap.containsKey(tChar)) {
                if (reverseMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                reverseMap.put(tChar, sChar);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add")); // true
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar")); // false
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title")); // true
    }
}
