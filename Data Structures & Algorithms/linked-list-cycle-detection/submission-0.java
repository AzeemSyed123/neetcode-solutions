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
    public boolean hasCycle(ListNode head) {

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null){
            //advance both the pointers
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            //if they meet means we found a loop
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
        
    }
}
