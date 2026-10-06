class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k>0){
            stack.pop();
            k--;
        }
        int start = 0;
        while(start < stack.size()-1 && stack.get(start) == '0'){
            start++;
        }
        StringBuilder result = new StringBuilder();
        for(int i=start;i<stack.size();i++){
            result.append(stack.get(i));
        }
        return result.toString();
    }
}