/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// Heapify nodes
// Take the minumum of those nodes, append it to the resulting list.
// Remove the node from the heap, if not null, add the next node to the heap.
// O(2logK)
// Iterate that node forward.
// Repeat while the heap is nonempty (n times)
// Total runtime: n*logK
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val)
                    return -1;
                else if (n1.val == n2.val)
                    return 0;
                else
                    return 1;
            }
        });
        // The proper way to heapify, O(n)
        pq.addAll(Arrays.asList(lists));

        ListNode head = null;
        ListNode tail = null;
        ListNode n = null;
        while (!pq.isEmpty()) {
            n = pq.poll();
            if (n.next != null) {
                pq.add(n.next);
            }
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }
        return head;
    }
}