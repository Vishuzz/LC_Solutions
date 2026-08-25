class Solution {
    static int countSubs(int[] nums,int mid,int n){
        int sub = 1,sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]+sum <= mid){
                sum += nums[i];
            }
            else{
                sub++;
                sum = nums[i];
            }
        }
        return sub;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            sum += nums[i];
        }
        int low = max,high = sum;
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int cnt = countSubs(nums,mid,n);
            if(cnt <= k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}