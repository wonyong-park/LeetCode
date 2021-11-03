class Solution {
    public int trap(int[] height) {
        int total = 0;

        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(calcMax(height,0, i), calcMax(height, i + 1, height.length));
            if (minHeight - height[i] > 0) {
                total += minHeight - height[i];
            }
        }

        return total;
    }

    private int calcMax(int[] height, int start, int end) {
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(max, height[i]);
        }

        return max;
    }
}