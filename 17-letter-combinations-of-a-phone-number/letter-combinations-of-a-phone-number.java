class Solution {
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    void backtrack(int index,String digits,StringBuilder curr,List<String> ans){
        if(index == digits.length()){
            ans.add(curr.toString());
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for(int i=0;i<s.length();i++){
            curr.append(s.charAt(i));
            backtrack(index+1,digits,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(0,digits,new StringBuilder(),ans);
        return ans;
    }
}