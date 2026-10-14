class Solution {
    public int largestHist(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Arrays.fill(nse,n);
        Arrays.fill(pse,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
         for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
               pse[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxi = 0;
        for(int i=0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            int area = width*arr[i];
            maxi = Math.max(maxi,area);
        }
        return maxi;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[][] pSum = new int[n][m];
        for(int j=0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                if(matrix[i][j] == '1'){
                    sum++;
                }
                else{
                    sum = 0;
                }
                pSum[i][j] = sum;
            }
        }
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,largestHist(pSum[i]));
        }
        return maxArea;
    }
}