class Solution {
    static long time(int[] piles,int hourly){
        long totalTime = 0;
        for(int i=0;i<piles.length;i++){
            totalTime += (piles[i] + hourly -1)/hourly;
        }
        return totalTime;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxi = piles[0];
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,piles[i]);
        }
        int ans = Integer.MAX_VALUE;
        int low=1,high=maxi;
        while(low <= high){
            int mid = low+(high-low)/2;
            long reqTime = time(piles,mid);
            if(reqTime <= h){
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