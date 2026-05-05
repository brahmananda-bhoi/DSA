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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        k %= n;
        if(k == 0)
            return head;
        n = n-k;
        temp = head;
        while(n != 1){
            n--;
            temp = temp.next;
        }
        ListNode res = temp.next;
        temp.next = null;
        temp = res;
        while(temp.next != null)
            temp = temp.next;
        temp.next = head;
        return res;
    }
}