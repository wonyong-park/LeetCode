class Solution {
    public final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> list, int start) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}