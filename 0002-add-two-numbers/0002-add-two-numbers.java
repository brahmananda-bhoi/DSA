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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode ans=null;
        ListNode t3=null;
        int c=0,temp;
        while(t1!=null && t2!=null){
            if(ans==null){
                temp=(int)(t1.val+t2.val)%10;
                t3 = new ListNode(temp);
                ans=t3;
                c=(t1.val+t2.val)/10;
                t1=t1.next;
                t2=t2.next;
            }
            else{
                temp=(int)(t1.val+t2.val+c)%10;
                t3.next =new ListNode(temp);
                c=(t1.val+t2.val+c)/10;
                t3=t3.next;
                t1=t1.next;
                t2=t2.next;
            }
        }
        while(t1!=null){
            temp=(int)(t1.val+c)%10;
            t3.next =new ListNode(temp);
            c=(t1.val+c)/10;
            t1=t1.next;
            t3=t3.next;
        }
        while(t2!=null){
            temp=(int)(t2.val+c)%10;
            t3.next =new ListNode(temp);
            c=(t2.val+c)/10;
            t2=t2.next;
            t3=t3.next;
        }
        if(c!=0)
            t3.next =new ListNode(c);
        return ans;
    }
}