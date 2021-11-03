class Solution {
    public int trap(int[] height) {
        int total = 0;

        //인덱스의 위치에서 봤을때 왼쪽 가장 긴 높이와 오른쪽 가장 긴 높이
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            max = Math.max(max, height[i]);
            left[i + 1] = max;
        }

        max = 0;
        for (int i = left.length-2; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            right[i] = max;
        }

        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(left[i], right[i]);
            if (minHeight - height[i] > 0) {
                total += minHeight - height[i];
            }
        }

        return total;
    }
}