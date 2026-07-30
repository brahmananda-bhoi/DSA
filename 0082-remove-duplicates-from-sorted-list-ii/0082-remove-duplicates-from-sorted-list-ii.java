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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            // If current node is a duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with this value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Link prev to the node after duplicates
                prev.next = head.next;
            } else {
                // Move prev pointer if no duplicate
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}