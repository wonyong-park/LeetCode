class Solution {
    static List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        //방문한것을 확인하는 변수
        boolean[] visited = new boolean[nums.length];
        //방문하면서 차례로 담을 변수
        int[] output = new int[nums.length];
        perm(nums, output, 0, visited);

        return result;
    }

    static void perm(int[] nums, int[] output, int depth, boolean[] visited){

        if(depth == nums.length){
            result.add(Arrays.stream(output).boxed().collect(Collectors.toList()));
        }

        for (int i = 0; i < nums.length; i++) {
            //i번째가 방문 안한경우
            if(visited[i] != true){
                //방문 처리
                visited[i] = true;
                //방문 값 입력
                output[depth] = nums[i];
                perm(nums,output,depth+1,visited);
                //방문이 끝나면
                visited[i] = false;
            }
        }

    }
}