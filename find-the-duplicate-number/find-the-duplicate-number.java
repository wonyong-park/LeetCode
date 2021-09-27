class Solution {
    public int findDuplicate(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                res = index;
                break;
            }

            nums[index] *= -1;
        }

        return res;
    }
}