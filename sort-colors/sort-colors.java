class Solution {
    public void sortColors(int[] nums) {
        int LeftIdx = 0; //0의 위치 인덱스
        int RightIdx = nums.length - 1; //2 위치할 인덱스
        int curIdx = 0;

        while (curIdx <= RightIdx) {
            if(nums[curIdx] == 2){
                int temp = nums[curIdx];
                nums[curIdx] = nums[RightIdx];
                nums[RightIdx] = temp;
                RightIdx--;
            }else if(nums[curIdx] == 0){
                int temp = nums[curIdx];
                nums[curIdx] = nums[LeftIdx];
                nums[LeftIdx] = temp;
                curIdx++;
                LeftIdx++;
            }else{
                curIdx++;
            }
        }
    }
}