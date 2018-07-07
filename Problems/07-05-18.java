class Solution {
    // Solves the longest absolute path problem from LeetCode.
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> lengthAtDepth = new HashMap<>(input.length());
        lengthAtDepth.put(-1, 0);
        int maxLength = 0;
        int begFileName = 0;
        int lenFileName;
        int depth = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\n' || i == input.length() - 1) {
                if (i == input.length() - 1) {
                    lenFileName = i - begFileName + 1;
                } else {
                    lenFileName = i - begFileName;
                }
                if (input.substring(begFileName, i).contains(".")) {
                    if ((lenFileName + lengthAtDepth.get(depth - 1)) > maxLength) {
                        maxLength = lenFileName + lengthAtDepth.get(depth - 1);
                    }
                }
                lengthAtDepth.put(depth, lengthAtDepth.get(depth - 1) + lenFileName + 1);
                depth = getDepth(i + 1, input);
                i += depth;
                begFileName = i + 1;
            }
        }
        return maxLength;
    }

    int getDepth(int beg, String input) {
        int depth = 0;
        for (int i = beg; i < input.length(); i++) {
            if (input.charAt(i) == '\t') {
                depth++;
            } else {
                break;
            }
        }
        return depth;
    }
}