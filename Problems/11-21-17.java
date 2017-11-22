class Solution {
    void inOrder(TreeNode n) {
        Queue q = new Queue();
        
        

    }
    class TreeNode {
        Object data;
        TreeNode left;
        TreeNode right;
    }
    class Queue {
        Node head;

        void enqueue(Object data) {
            Node n = new Node(data);
            if (head == null) {
                head = n;
                return;
            }
            n.next = head;
            head = n;
        }
        Object dequeue() {
            if (head == null) return null;
            return head.data;
        }
        boolean isEmpty() {
            return head == null;
        }
        class Node {
            Object data;
            Node next;

            Node(Object data) {
                this.data = data;
            }
        }
    }
}