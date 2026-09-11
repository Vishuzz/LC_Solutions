class Solution {
    static void backtrack(int start,int[] nums,List<Integer> curr,List<List<Integer>> result){
         result.add(new ArrayList<>(curr));

         for(int i=start;i<nums.length;i++){
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(i+1,nums,curr,result);
            curr.remove(curr.size()-1);
         }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result;
    }
}