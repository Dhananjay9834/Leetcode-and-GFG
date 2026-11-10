/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Create a Min Heap
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first node of every linked list
        for (int i = 0; i < lists.length; i++) {

            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process nodes until Priority Queue becomes empty
        while (!pq.isEmpty()) {

            // Get the smallest node
            ListNode smallestNode = pq.poll();

            // Attach it to the answer
            current.next = smallestNode;
            current = current.next;

            // Add the next node from the same list
            if (smallestNode.next != null) {
                pq.offer(smallestNode.next);
            }
        }

        return dummy.next;
    }
}
