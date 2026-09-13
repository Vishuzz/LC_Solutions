class Solution {
    final String[] map;
    public Solution(){
        map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    }
    void backtrack(int index,String digits,String curr,List<String> ans){
        if(index == digits.length()){
            ans.add(curr);
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for(int i=0;i<s.length();i++){
            backtrack(index+1,digits,curr+s.charAt(i),ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(0,digits,"",ans);
        return ans;
    }
}