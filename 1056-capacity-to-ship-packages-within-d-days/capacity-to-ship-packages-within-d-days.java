class Solution {
    static int getResult(int[] weights,int mid,int n){
        int day = 1;
        int load = 0;
        for(int i=0;i<n;i++){
            if(load + weights[i] > mid){
                day++;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int maxi = -1;
        for(int i=0;i<n;i++){
            sum += weights[i];
            maxi = Math.max(maxi,weights[i]);
        }
        int low = maxi,high = sum;
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int count = getResult(weights,mid,n);
            if(count <= days){
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