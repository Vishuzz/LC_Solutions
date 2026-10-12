class Solution {

    int[] findNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   arr[stack.peek()] > arr[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        return nse;
    }

    int[] findPse(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Arrays.fill(pse, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nse = findNse(heights);
        int[] pse = findPse(heights);
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxi = Math.max(maxi, area);
        }
        return maxi;
    }
}
