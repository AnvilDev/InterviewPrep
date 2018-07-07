class Solution {
    // This solves Plus One from LeetCode.
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
            if (i == 0) {
                return moveOver(digits);
            }
        }
        return digits;
    }

    private int[] moveOver(int[] digits) {
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}