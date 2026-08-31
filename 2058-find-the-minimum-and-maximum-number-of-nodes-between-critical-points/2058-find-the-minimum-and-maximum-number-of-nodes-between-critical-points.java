class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int position = 1;
        int firstCritical = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {
                if (firstCritical == -1) {
                    firstCritical = position;
                }
                if (prevCritical != -1) {
                    minDistance = Math.min(
                        minDistance,
                        position - prevCritical
                    );
                }
                prevCritical = position;
            }
            prev = curr;
            curr = curr.next;
            position++;
        }
        if (firstCritical == -1 || prevCritical == firstCritical) {
            return new int[]{-1, -1};
        }
        int maxDistance = prevCritical - firstCritical;
        return new int[]{minDistance, maxDistance};
    }
}