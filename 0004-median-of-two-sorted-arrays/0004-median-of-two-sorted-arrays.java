class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int first = 0;
        int second = 0;
        while(first < nums1.length && second < nums2.length){
            if(nums1[first] < nums2[second]){
                ans.add(nums1[first]);
                first++;
            }
            else{
                ans.add(nums2[second]);
                second++;
            }
        }
        while(first < nums1.length){
            ans.add(nums1[first]);
            first++;
        }

        while(second < nums2.length){
            ans.add(nums2[second]);
            second++;
        }

        int size = ans.size();
        if(size % 2 == 0){
            int mid1 = size/2-1;
            int mid2 = size/2;
            double res = (ans.get(mid1) + ans.get(mid2))/2.0;
            return res;
        }else{
            int mid = size/2;
            return ans.get(mid);
        }
    }
}