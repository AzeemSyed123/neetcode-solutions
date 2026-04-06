class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnNode = new ListNode(Integer.MIN_VALUE); // dummy head to simplify logic
        ListNode headNode = returnNode; // save reference to the start

        // Compare nodes from both lists and attach the smaller one
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                returnNode.next = list1; // list1 is smaller, attach it
                list1 = list1.next;      // move list1 forward
            } else {
                returnNode.next = list2; // list2 is smaller, attach it
                list2 = list2.next;      // move list2 forward
            }
            returnNode = returnNode.next; // move our pointer forward
        }

        // One list is exhausted — attach the remaining nodes from the other
        if (list1 == null) {
            returnNode.next = list2;
        } else {
            returnNode.next = list1;
        }

        return headNode.next; // skip the dummy head
    }
}
// Time:  O(n + m) — n and m are the lengths of the two lists
// Space: O(1) — no extra data structures, just rearranging pointers