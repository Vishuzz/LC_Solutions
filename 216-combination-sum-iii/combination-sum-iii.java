class Solution {
    static void backtrack(int n,int start,List<Integer> curr,int k,List<List<Integer>> ans){
        if(n == 0 && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=9;i++){
            if(i <= n){
                curr.add(i);
                backtrack(n-i,i+1,curr,k,ans);
                curr.remove(curr.size()-1);
            }
            else{
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(n,1,curr,k,ans);
        return ans;
    }
}