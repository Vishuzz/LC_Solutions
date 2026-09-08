class Solution {
    static void findAllCombos(int index,int[] arr,int target,List<List<Integer>> res,List<Integer> curr){
        if(index == arr.length){
            if(target == 0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        if(arr[index] <= target){
            curr.add(arr[index]);
            findAllCombos(index,arr,target-arr[index],res,curr);
            curr.remove(curr.size()-1);
        }
        findAllCombos(index+1,arr,target,res,curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findAllCombos(0,candidates,target,res,new ArrayList<>());
        return res;
    }
}