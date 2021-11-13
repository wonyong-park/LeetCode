class Solution {
    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while (left != right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, width * minHeight);

            if (height[left] > height[right]) {
                right--;
            }else{
                left++;
            }

        }

        return max;
    }
}