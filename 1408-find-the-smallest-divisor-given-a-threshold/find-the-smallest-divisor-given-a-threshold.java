class Solution {
    static long getResult(int[] nums, int midNum,int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += (int)Math.ceil((double)nums[i]/midNum);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            high = Math.max(high,nums[i]);
        }
        int finalAns = -1;
        while(low <= high){
            int mid = (low+high)/2;
            long sum = getResult(nums,mid,n);
            if(sum <= threshold){
                finalAns = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return finalAns;
    }
}