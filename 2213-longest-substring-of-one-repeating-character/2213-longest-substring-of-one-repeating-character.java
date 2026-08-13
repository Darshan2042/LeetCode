class Solution {
    class Node {
        char left;
        char right;
        int prefix;
        int suffix;
        int max;
        int len;
        Node(char left, char right, int prefix, int suffix, int max, int len) {
            this.left = left;
            this.right = right;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.len = len;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];

            arr[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int start, int end) {

        if (start == end) {

            tree[node] = new Node(
                    arr[start],
                    arr[start],
                    1,
                    1,
                    1,
                    1
            );

            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);

        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int index) {

        if (start == end) {

            tree[node] = new Node(
                    arr[index],
                    arr[index],
                    1,
                    1,
                    1,
                    1
            );

            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node left, Node right) {

        int prefix = left.prefix;
        int suffix = right.suffix;

        int max = Math.max(left.max, right.max);

        if (left.right == right.left) {

            max = Math.max(
                    max,
                    left.suffix + right.prefix
            );

            if (left.prefix == left.len) {
                prefix = left.len + right.prefix;
            }

            if (right.suffix == right.len) {
                suffix = left.suffix + right.len;
            }
        }

        return new Node(
                left.left,
                right.right,
                prefix,
                suffix,
                max,
                left.len + right.len
        );
    }
}