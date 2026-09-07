class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i < n){
            list.add(nums1[i]);
            i++;
        }

        while(j < m){
            list.add(nums2[j]);
            j++;
        }

        int size = list.size();
        if(size % 2 == 0){
            int mid1 = size / 2 -1;
            int mid2 = size / 2;
            return (list.get(mid1) + list.get(mid2)) / 2.0;
        }
        else{
            int mid = size /2;
            return list.get(mid);
        }
    }
}