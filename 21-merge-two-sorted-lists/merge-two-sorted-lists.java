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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode merge = new ListNode();
        ListNode head = merge;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                merge.next = curr1;
                curr1 = curr1.next;
            }
            else{
                merge.next = curr2;
                curr2 = curr2.next;
            }
            merge = merge.next;
        }
        while(curr1 != null){
            merge.next = curr1;
            curr1 = curr1.next;
            merge = merge.next;
        }
        while(curr2 != null){
            merge.next = curr2;
            curr2 = curr2.next;
            merge = merge.next;
        }
        return head.next;
    }
}