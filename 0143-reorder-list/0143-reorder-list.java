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
    public void reorderList(ListNode head) {
        //Using slow and fast pointers, reach at the half way and end of the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half of the list
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode first = head;
        ListNode second = prev;
        while(second.next!=null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}

/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (!stack.isEmpty()) {
            ListNode next = curr.next;
            ListNode node = stack.pop();
            curr.next = node;
            node.next = next;
            curr = next;
        }
    }
}
*/