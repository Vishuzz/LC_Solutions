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
        if(lists == null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode curr = lists[i];
            while(curr != null){
                arr.add(curr.val);
                curr = curr.next;
            }
        }
        Collections.sort(arr);
        ListNode result = new ListNode(0);
        ListNode curr = result;
        for(int value : arr){
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return result.next;
    }
}