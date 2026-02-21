/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node tail = dummy;
            // Traverse current level
            for (Node p = curr; p != null; p = p.next) {
                if (p.left != null) {
                    tail.next = p.left;
                    tail = tail.next;
                }
                if (p.right != null) {
                    tail.next = p.right;
                    tail = tail.next;
                }
            }
            // Move to next level
            curr = dummy.next;
        }
        return root;
    }
}