class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node n = new Node(insertVal, null);
            n.next = n;
            return n;
        }
        Node start = head;
        head = head.next;
        while (start != head) {
            if (head.val <= insertVal && insertVal <= head.next.val) {
                insertAfter(head, insertVal);
                return start;
            } else if (isEnd(head) && (head.val <= insertVal || insertVal <= head.next.val)) {
                insertAfter(head, insertVal);
                return start;
            }
            head = head.next;
        }
        insertAfter(head, insertVal);
        return start;
    }
    
    public void insertAfter(Node head, int insertVal) {
        Node n = new Node(insertVal, head.next);
        head.next = n;
    }
    
    public boolean isEnd(Node n) {
        return (n.val > n.next.val);
    }
}
