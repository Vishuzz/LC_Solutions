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
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        ListNode curr = head;
        while(curr != null){
            list1.add(curr.val);
            curr = curr.next;
        }
        //Now reverse the linked list
        ListNode prev = null;
        curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr = prev;
        while(curr != null){
            list2.add(curr.val);
            curr = curr.next;
        }
        return list1.equals(list2);
    }
}