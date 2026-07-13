public class Codec {
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("#,");
            } else {
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (!arr[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            if (!arr[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}