/**
 * This class is the solution to the following problem:
 * Traverse a tree in-order, pre-order, and post-order.
 */
class Solution {
    /**
     * This method traverses a tree in-order.
     * @param root The root of the tree.
     */
    void inOrder(TreeNode root) {
        TreeNode temp;
        Queue q = new Queue();
        q.enqueue(root);
        while (!q.isEmpty()) {
            temp = q.dequeue();
            System.out.print(temp.data);
            if (temp.left != null) q.enqueue(temp.left);
            if (temp.right != null) q.enqueue(temp.right);
        }
    }

    /**
     * This method traverses a tree pre-order.
     * @param root The root of the tree.
     */
    void preOrder(TreeNode root) {
        System.out.print(root);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        } 
    }

    /**
     * This method traverses a tree post-order.
     * @param root The root of the tree.
     */
    void postOrder(TreeNode root) {
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        } 
        System.out.print(root);
    }

    /**
     * This class is the node of the tree we are receiving.
     */
    class TreeNode {
        Object data;
        TreeNode left;
        TreeNode right;
    }

    /**
     * This class is a linked-list implementation of a queue.
     */
    class Queue {
        Node head;
        Node tail;

        void enqueue(Object data) {
            Node n = new Node(data);
            if (head == null) {
                head = n;
                tail = n;
                return;
            }
            tail.next = n;
        }

        Object dequeue() {
            if (head == null) return null;
            return head.data;
        }
        boolean isEmpty() {
            return head == null;
        }

        /**
         * This class is the node in the linked list.
         */
        class Node {
            Object data;
            Node next;

            Node(Object data) {
                this.data = data;
            }
        }
    }
}