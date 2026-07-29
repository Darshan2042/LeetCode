class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }
    TrieNode root = new TrieNode();
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }
    private int getMaxXor(int num) {
        TrieNode node = root;
        if (node.child[0] == null && node.child[1] == null) {
            return -1;
        }
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[1 - bit] != null) {
                maxXor |= (1 << i);
                node = node.child[1 - bit];
            } else {
                node = node.child[bit];
            }
        }
        return maxXor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int q = queries.length;
        int[][] offline = new int[q][3];
        for (int i = 0; i < q; i++) {
            offline[i][0] = queries[i][1];
            offline[i][1] = queries[i][0];
            offline[i][2] = i;
        }
        Arrays.sort(offline, (a, b) -> Integer.compare(a[0], b[0]));
        int[] answer = new int[q];
        int index = 0;
        for (int[] query : offline) {
            int m = query[0];
            int x = query[1];
            int originalIndex = query[2];
            while (index < nums.length && nums[index] <= m) {
                insert(nums[index]);
                index++;
            }
            answer[originalIndex] = getMaxXor(x);
        }
        return answer;
    }
}