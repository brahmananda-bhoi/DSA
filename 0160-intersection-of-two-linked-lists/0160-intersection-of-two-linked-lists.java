/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans=null;
        Stack<ListNode> l1=new Stack<>();
        Stack<ListNode> l2=new Stack<>();
        ListNode t=headA;
        while(t!=null){
            l1.push(t);
            t=t.next;
        }
        t=headB;
        while(t!=null){
            l2.push(t);
            t=t.next;
        }
        while(!l1.isEmpty() && !l2.isEmpty()){
            t=l1.pop();
            if(t != l2.pop())
                break;
            else
                ans=t;
        }
        return ans;
    }
}