class Solution {
    void inOrder(TreeNode n) {
        Node temp;
        Queue q = new Queue();
        q.enqueue(n);
        while (!q.isEmpty()) {
            temp = q.dequeue();
            System.out.print(temp.data);
            if (temp.left != null) q.enqueue(temp.left);
            if (temp.right != null) q.enqueue(temp.right);
        }
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