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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        int reachNode = count - n;
        if(reachNode == 0){
            return head.next;
        }
        ListNode temp = head;
        while(reachNode > 1){
            temp = temp.next;
            reachNode--;
        }
        temp.next = temp.next.next;
        return head;
    }
}