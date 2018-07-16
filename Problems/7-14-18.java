class MinStack {
    // Solves Min Stack from LeetCode.
    private Stack<Pair> stack;

    class Pair {
        public int element;
        public int min;

        public Pair(int element, int min) {
            this.element = element;
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() == 0) {
            stack.push(new Pair(x, x));
        } else {
            stack.push(new Pair(x, Math.min(x, stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().element;
    }

    public int getMin() {
        return stack.peek().min;
    }
}