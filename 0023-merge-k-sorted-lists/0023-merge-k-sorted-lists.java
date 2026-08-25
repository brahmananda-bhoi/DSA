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
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                q.offer(node);
            }
        }
        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            prev.next = temp;
            prev = prev.next;
            if (temp.next != null) {
                q.offer(temp.next);
            }
        }
        return dummy.next;
    }
}