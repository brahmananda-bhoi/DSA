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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            // Store next node (we'll lose it when we insert)
            ListNode next = curr.next;
            // Find the correct position to insert curr
            ListNode prev = dummy;
            ListNode pos = dummy.next;
            // Move pos until we find where curr should go
            while (pos != null && pos.val < curr.val) {
                prev = pos;
                pos = pos.next;
            }
            // Insert curr between prev and pos
            curr.next = pos;
            prev.next = curr;
            // Move to next element in original list
            curr = next;
        }
        return dummy.next;
    }
}