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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1)
            return null;
        Stack<ListNode> l=new Stack<>();
        ListNode temp=head;
        int ndc=0;
        while(temp!=null){
            l.push(temp);
            temp=temp.next;
        }
        int c=n;
        while(c>=0 && !l.isEmpty()){
            temp=l.pop();
            c--;
            ndc++;
        }
        if(n==1){
            temp.next=null;
        }
        else{
            if(temp==head && ndc==n){
                head=head.next;
            }
            else{
                ListNode t=temp.next;
                temp.next=t.next;
            }
        }
        return head;
    }
}