class Solution {
    static boolean possible(int[] arr,int day,int m,int k){
        int n = arr.length;
        int count = 0,bqs=0;
        for(int i=0;i<n;i++){
            if(arr[i] <= day){
                count++;
            }
            else{
                bqs += count/k;
                count = 0;
            }
        }
        bqs += count/k;
        if(bqs >= m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        int ans = -1;
        for(int i=0;i<n;i++){
            high = Math.max(high,bloomDay[i]);
            low = Math.min(low,bloomDay[i]);
        }
        while(low <= high){
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,m,k)){
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