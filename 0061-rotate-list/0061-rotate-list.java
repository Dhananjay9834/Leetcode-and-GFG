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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode last = head;
        int len = 1;

        while(last.next != null){
            last = last.next;
            len++;
        }

        k = k % len;

        if(k == 0){
            return head;
        }

        ListNode temp = head;

        for(int i = 1; i < len - k; i++){
            temp = temp.next;
        }

        last.next = head;
        head = temp.next;
        temp.next = null;

        return head;
    }
}