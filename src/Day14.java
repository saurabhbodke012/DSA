import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
public class Day14 {

    //Path Sum II
    List<List<Integer>> result ;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        path =  new ArrayList<Integer>();
        helper (root,targetSum,0);
        return result;
    }

    public void helper( TreeNode root, int target, int sum){

        if( root == null){
            return;
        }

        // action
        sum +=  root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if( sum == target){
                result.add(new ArrayList<>(path));
            }
        }

        // recursion
        helper(root.left, target ,sum);
        helper(root.right,target ,sum);

        // backtrack
        path.remove(path.size()-1);

    }


    // Sum Root to Leaf Numbers
    public int sumNumbers(TreeNode root) {
        return helper (root, 0);
    }

    public int helper( TreeNode root, int currSum){

        if( root == null){
            return 0;
        }

        currSum = currSum*10 + root.val;
        if(root.left == null && root.right == null){
            return currSum;
        }

        int sumLeft = helper(root.left, currSum);
        int sumRight = helper(root.right, currSum);

        return sumLeft + sumRight;

    }
    
}
