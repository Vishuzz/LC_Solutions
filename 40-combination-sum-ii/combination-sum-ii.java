class Solution {
    static void findAllCombos(int index,int[] arr,int target,List<List<Integer>> ans, List<Integer> curr){
            if(target == 0){
                ans.add(new ArrayList<>(curr));
                return;
            }
        for(int i=index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            curr.add(arr[i]);
            findAllCombos(i+1,arr,target-arr[i],ans,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findAllCombos(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}