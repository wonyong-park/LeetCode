class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], list, result);
        }

        return result;
    }

    private static void backtracking(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }
}