class Solution {
    public int thirdMax(int[] nums) {
        long[] max = initMaxArray();
        for (int num : nums) {
            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num > max[1]) {
                if (num != max[0]) {
                    max[2] = max[1];
                    max[1] = num;
                }
            } else if (num > max[2]) {
                if (num != max[1]) {
                    max[2] = num;
                }
            }
        }
        return (max[2] == Long.MIN_VALUE) ? (int) max[0] : (int) max[2];
    }
    long[] initMaxArray() {
        long[] max = new long[3];
        for (int i = 0; i < 3; i++) {
            max[i] = Long.MIN_VALUE;
        }
        return max;
    }
}
