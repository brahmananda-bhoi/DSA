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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode dummy = new ListNode();
        while(head != null){
            ListNode temp = head;
            head=head.next;
            temp.next=dummy.next;
            dummy.next=temp;
        }
        return dummy.next;
    }
}


/*
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode h;
        if(head==null || head.next==null){
            return head;
        }
        else{
            ListNode t=head.next;
            h=head;
            h.next=null;
            ListNode t1;
            while(t!=null){
                t1=t;
                t=t.next;
                t1.next=h;
                h=t1;
            }
        }
        return h;
    }
}
*/