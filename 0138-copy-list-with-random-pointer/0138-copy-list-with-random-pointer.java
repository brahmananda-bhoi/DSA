/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node temp=head;
        while(temp!=null){
            Node copy=new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=copy.next;
        }
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
            if(temp.random!=null)
                copy.random=temp.random.next;
            // else
            //     copy.random=null;
            temp=temp.next.next;
        }
        Node dummy=new Node(-1);
        Node cur=dummy;
        temp=head;
        while(temp!=null){
            cur.next=temp.next;
            cur=cur.next;
            temp.next=cur.next;
            temp=temp.next;
        }
        cur.next=null;
        return dummy.next;
    }
}