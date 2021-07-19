class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        int[] output = new int[nums.length];
        int n = nums.length;

        perm(result, nums, output, visited, 0, n);

        return result;
    }

    static void perm(List<List<Integer>> result, int[]arr, int[] output, boolean[] visited, int depth, int n) {
        if (depth == n) {
            List<Integer> dump = new ArrayList<>();
            for (Integer i : output){
                dump.add(i);
            }
            result.add(dump);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(result, arr, output, visited, depth + 1, n);
                visited[i] = false;
            }
        }
    }
}