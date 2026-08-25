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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s=new Stack<>();
        ListNode temp=head,t2=head;
        if(temp==null || temp.next==null)
            return true;
        while(t2!=null && t2.next!=null){
            s.push(temp.val);
            temp=temp.next;
            t2=t2.next.next;
        }
        if(t2!=null)
            temp=temp.next;
        while(temp!=null){
            if(s.pop()!=temp.val)
                return false;
            temp=temp.next;
        }
        return true;
    }
}