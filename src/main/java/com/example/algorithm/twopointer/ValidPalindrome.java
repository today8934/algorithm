package com.example.algorithm.twopointer;

/**
 * 125. Valid Palindrome
 * Easy
 * Topics
 * Companies
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        boolean result = true;
        int p1 = 0;
        int p2 = s.length() - 1;
        s = s.toLowerCase();

        while (p1 < p2) {
            char left = s.charAt(p1);
            char right = s.charAt(p2);

            if (!Character.isLetterOrDigit(left)) {
                p1++;
                continue;
            }

            if (!Character.isLetterOrDigit(right)) {
                p2--;
                continue;
            }

            if (left != right) {
                result = false;
                break;
            }

            p1++;
            p2--;
        }

        return result;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println(result);
    }
}
