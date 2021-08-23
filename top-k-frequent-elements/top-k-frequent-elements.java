import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int[][] arr = new int[hm.size()][2];
        int i = 0;
        for (int num : hm.keySet()) {
            arr[i][0] = num;
            arr[i][1] = hm.get(num);
            i++;
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = arr[j][0];
        }

        return result;
    }
}