class Solution {
    public int hammingDistance(int x, int y) {
        int ham = x ^ y;
        String hamString = Integer.toBinaryString(ham);
        int hamDist = 0;
        for (int i = 0; i < hamString.length(); i++) {
            if (hamString.charAt(i) == '1') {
                hamDist++;
            }
        }
        return hamDist;
    }
}
