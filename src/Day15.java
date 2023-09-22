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
}
