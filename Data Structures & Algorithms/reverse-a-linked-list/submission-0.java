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
// create a stack(to push all the values of the linked list)
// then create a new linked list to pop the stack and add the values sequentially to the new linked list resulting in a reversed linked list
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> valueStack = new Stack<>();
        while(head != null){
            valueStack.push(head.val);
            head = head.next;
        }
        ListNode reversedList = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = reversedList;
        
        while(!valueStack.isEmpty()){
            ptr.next = new ListNode(valueStack.pop());
            ptr = ptr.next;
        }
        return reversedList.next;

    }
}
