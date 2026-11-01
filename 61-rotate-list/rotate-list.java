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
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        k = k % count;
        while(k > 0){
            ListNode prev = null;
            curr = head;
            while(curr.next != null){
                prev = curr;
                curr = curr.next;
            }
            curr.next = head;
            head = curr;
            prev.next = null;

            k--;
        }
        return head;
    }
}