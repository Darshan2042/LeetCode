class Solution {
    int ans = 0;
    class Info {
        boolean bst;
        int min, max, sum;
        Info(boolean bst, int min, int max, int sum) {
            this.bst = bst;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    Info dfs(TreeNode root) {
        if (root == null)
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Info l = dfs(root.left);
        Info r = dfs(root.right);
        if (l.bst && r.bst && root.val > l.max && root.val < r.min) {
            int sum = l.sum + r.sum + root.val;
            ans = Math.max(ans, sum);
            return new Info(
                true,
                Math.min(root.val, l.min),
                Math.max(root.val, r.max),
                sum
            );
        }
        return new Info(false, 0, 0, 0);
    }
}