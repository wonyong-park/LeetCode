class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if(!list.contains(num)){
                list.add(num);
            }else{
                list.remove(list.indexOf(num));
            }
        }

        return list.get(0);
    }
}