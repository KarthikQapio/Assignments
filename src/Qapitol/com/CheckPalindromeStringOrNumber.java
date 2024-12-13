package Qapitol.com;

public class CheckPalindromeStringOrNumber {
        public static boolean isStringPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        public static boolean isNumberPalindrome(int num) {
            int originalNum = num;
            int reversedNum = 0;

            while (num > 0) {
                int digit = num % 10;
                reversedNum = reversedNum * 10 + digit;
                num /= 10;
            }

            return originalNum == reversedNum;
        }

        public static void main(String[] args) {
            String testString = "KarthikAutomation";
            if (isStringPalindrome(testString)) {
                System.out.println(testString + " is a palindrome.");
            } else {
                System.out.println(testString + " is not a palindrome.");
            }
            int testNumber = 121;
            if (isNumberPalindrome(testNumber)) {
                System.out.println(testNumber + " is a palindrome.");
            } else {
                System.out.println(testNumber + " is not a palindrome.");
            }
        }
    }


