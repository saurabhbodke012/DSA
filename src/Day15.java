import java.util.HashMap;

public class Day15 {

    // Construct Binary Tree from Preorder and Inorder Traversal
    HashMap<Integer, Integer> map ;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || preorder == null){
            return null;
        }

        map = new HashMap<Integer, Integer>();

        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder,0, inorder.length-1);
    }

    private TreeNode helper( int[] preorder, int start, int end){

        // Base
        if( start>end){
            return null;
        }
        // Logic

        int rootVal = preorder[index];
        int rootIndex = map.get(rootVal);
        index++;
        TreeNode root = new TreeNode(rootVal);
        root.left  = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Remove nth Node from LinkedList
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if( head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count =0;

        while( count <=n){
            fast = fast.next;
            count++;
        }

        while(fast != null){
            slow = slow.next;
            fast= fast.next;
        }

        slow.next = slow.next.next; 
        return dummy.next;
    }
}
