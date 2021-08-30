class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        int val = 1;
        for (int i = 0; i < left.length; i++) {
            left[i] = val;
            val *= nums[i];
        }

        val = 1;
        for (int i = left.length-1; i >= 0; i--) {
            right[i] = val;
            val *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}