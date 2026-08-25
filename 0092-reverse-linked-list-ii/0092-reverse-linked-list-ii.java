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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;
        int c=0;
        ListNode prev=null;
        ListNode start=null;
        ListNode end=null;
        ListNode temp=head;
        while(temp!=null){
            c++;
            if(c==left-1)
                prev=temp;
            if(c==left)
                start=temp;
            if(c==right){
                end=temp;
                break;
            }
            temp=temp.next;
        }
        ListNode tail=end.next;
        Stack<ListNode> stk = new Stack<>();
        temp=start;
        while(temp!=tail){
            stk.push(temp);
            temp=temp.next;
        }
        temp=stk.pop();
        start=temp;
        while(!stk.isEmpty()){
            temp.next=stk.pop();
            temp=temp.next;
        }
        temp.next=tail;
        if(prev==null)
            return start;
        prev.next=start;
        return head;
    }
}