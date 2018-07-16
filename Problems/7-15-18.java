// DFS Solution
class Solution {
    class Node {
        public char val;
        public Node next;

        public Node(char val) {
            this.val = val;
            this.next = null;
        }
    }

    HashMap<Character, char[]> digitToChars;

    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) {
            List<String> out = new ArrayList<String>();
            return out;
        }
        // Initialize map of digits to characters.
        digitToChars = new HashMap<>();
        digitToChars.put('2', new char[] { 'a', 'b', 'c' });
        digitToChars.put('3', new char[] { 'd', 'e', 'f' });
        digitToChars.put('4', new char[] { 'g', 'h', 'i' });
        digitToChars.put('5', new char[] { 'j', 'k', 'l' });
        digitToChars.put('6', new char[] { 'm', 'n', 'o' });
        digitToChars.put('7', new char[] { 'p', 'q', 'r', 's' });
        digitToChars.put('8', new char[] { 't', 'u', 'v' });
        digitToChars.put('9', new char[] { 'w', 'x', 'y', 'z' });

        List<Node> permNodes = getPermutations(digits);
        List<String> out = new ArrayList<String>();
        for (Node n : permNodes) {
            out.add(linkedListToString(n));
        }
        return out;
    }

    public String linkedListToString(Node n) {
        StringBuilder str = new StringBuilder();
        while (n != null) {
            str.append(n.val);
            n = n.next;
        }
        return str.toString();
    }

    public List<Node> getPermutations(String digits) {
        List<Node> perms = null;
        if (digits.length() > 1) {
            perms = getPermutations(digits.substring(1));
        }
        List<Node> out = new ArrayList<Node>();
        char[] chars = digitToChars.get(digits.charAt(0));
        for (char c : chars) {
            if (perms == null) {
                out.add(new Node(c));
            } else {
                for (Node n : perms) {
                    Node ch = new Node(c);
                    ch.next = n;
                    out.add(ch);
                }
            }
        }
        return out;
    }

}

// BFS Solution
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        // Create a LinkedList queue.
        LinkedList<String> combinations = new LinkedList<>();
        combinations.add("");

        // Pseudo-HashMap of digit to string.
        String[] digitToStr = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        // Declare variables beforehand, less allocations.
        String prevComb = null;
        String digitStr = null;

        // Iterate through every digit.
        for (int i = 0; i < digits.length(); i++) {

            // We only want to our strings to be of length i, the number of digits we've
            // gone through.
            while (combinations.peek().length() == i) {

                // Dequeue the previous combination.
                prevComb = combinations.remove();
                digitStr = digitToStr[Character.getNumericValue(digits.charAt(i))];

                // Iterate and add to the previous combination a character from the next digit,
                // for all characters.
                for (int j = 0; j < digitStr.length(); j++) {
                    // Enqueue the new combination.
                    combinations.add(prevComb + digitStr.charAt(j));
                }
            }
        }
        return combinations;
    }
}
