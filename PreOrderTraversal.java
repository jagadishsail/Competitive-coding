/*
 * Java Program to traverse a binary tree using PreOrder traversal. 
 * In PreOrder the node value is printed first, followed by visit
 * to left and right subtree. 
 * input:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 
 * output: 1 2 3 4 5 6 
 */

import java.util.ArrayList;

public class PreOrderTraversal {

    public static void main(String[] args) {
        // Definition for binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new  TreeNode(3);

        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        //Pre order using Recursion
        ArrayList<Integer> result = preorderTraversal(root);
        result.forEach( element -> {
                        System.out.println(element);
        });
    }

     public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result=new ArrayList<>();
        preorder(result,A);
        return result;
    }


    private static void preorder(ArrayList<Integer> result, TreeNode A){
        if(A==null) return;
        result.add(A.val);
        preorder(result, A.left);
        preorder(result, A.right);  
    }

    static class TreeNode {
        TreeNode left, right;
        Integer val;

        TreeNode(Integer value) { 
            this.val = value; 
            left = right = null; 
        }
        
    }
}
