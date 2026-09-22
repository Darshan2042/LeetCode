import java.util.*;

class Solution {

    static class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }

    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Permanent update
            update(1, 0, n - 1, index, value);

            // Query nums[start ... n-1]
            Node result = query(1, 0, n - 1, start, n - 1);

            answer[i] = result.count[x];
        }

        return answer;
    }

    // Build segment tree
    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].count[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two segments
    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        // Product of complete segment
        result.product = (left.product * right.product) % k;

        /*
         * Prefixes completely inside LEFT
         */
        for (int x = 0; x < k; x++) {
            result.count[x] += left.count[x];
        }

        /*
         * Prefixes that use all of LEFT
         * and then some prefix of RIGHT.
         *
         * If product(left) = p
         * and prefix(right) = r
         *
         * new product = (p * r) % k
         */
        for (int r = 0; r < k; r++) {

            int newRemainder =
                    (left.product * r) % k;

            result.count[newRemainder] += right.count[r];
        }

        return result;
    }

    // Update nums[index] = value
    private void update(
            int node,
            int left,
            int right,
            int index,
            int value) {

        if (left == right) {

            int rem = value % k;

            tree[node] = new Node(k);
            tree[node].product = rem;
            tree[node].count[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {

            update(
                    node * 2,
                    left,
                    mid,
                    index,
                    value
            );

        } else {

            update(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    index,
                    value
            );
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // Query [queryLeft, queryRight]
    private Node query(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight) {

        // Completely inside
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        // Completely in left
        if (queryRight <= mid) {

            return query(
                    node * 2,
                    left,
                    mid,
                    queryLeft,
                    queryRight
            );
        }

        // Completely in right
        if (queryLeft > mid) {

            return query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    queryLeft,
                    queryRight
            );
        }

        // Crosses both sides
        Node leftResult = query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
        );

        Node rightResult = query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
        );

        return merge(leftResult, rightResult);
    }
}