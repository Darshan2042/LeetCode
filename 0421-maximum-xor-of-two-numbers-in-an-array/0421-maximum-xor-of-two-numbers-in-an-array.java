class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }
    TrieNode root = new TrieNode();
    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }

    public int getMaxXOR(int num) {
        TrieNode node = root;
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
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, getMaxXOR(num));
        }
        return ans;
    }
}