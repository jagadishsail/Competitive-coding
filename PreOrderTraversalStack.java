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
import java.util.Stack;

public class PreOrderTraversalStack {

    public static void main(String[] args) {
        // Definition for binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new  TreeNode(3);

        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        //Pre order using Stack
        ArrayList<Integer> result = preorderTraversal(root);
        
        //Print result
        result.forEach( element -> { System.out.println(element);});
    }

     public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        // Create an empty stack and push root to it
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) add to result 
         b) push its right child
         c) push its left child
         Note that right child is pushed first and then left, so that left is processed first(LIFO Last In First Out) */
        while(!stack.isEmpty()){
             TreeNode current = stack.pop();
             result.add(current.val);

             if(current.right != null){
                 stack.push(current.right);
             }
             
             if(current.left != null){
                 stack.push(current.left);
             }
            }
        return result;
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
