class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek()>0 && asteroids[i]<0){
                int top = stack.peek();
                if(top < -asteroids[i]){
                    stack.pop();
                }
                else if(top == -asteroids[i]){
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            res[i] = stack.get(i);
        }
        return res;
    }
}