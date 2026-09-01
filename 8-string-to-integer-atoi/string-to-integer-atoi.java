class Solution {
    static int helper(String s, int i, long num, int sign) {
        // Base case: end or non-digit
        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return (int)(sign * num);

        // Update num
        num = num * 10 + (s.charAt(i) - '0');

        // Clamp overflow
        if (sign * num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (sign * num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        // Recurse
        return helper(s, i + 1, num, sign);
    }
    public int myAtoi(String s) {
        int i = 0;

        // Skip whitespaces
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // Handle sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Recursive helper
        return helper(s, i, 0, sign);
    }
}