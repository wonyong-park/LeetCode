import java.util.*;
import static java.util.Map.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue() -  o1.getValue();
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();

        }

        return result;
    }
}