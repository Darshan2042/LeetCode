class Solution {
    int post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[post--]);
        int index = start;
        while (inorder[index] != root.val) index++;
        root.right = build(inorder, postorder, index + 1, end);
        root.left = build(inorder, postorder, start, index - 1);
        return root;
    }
}