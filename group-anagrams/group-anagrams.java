class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<>();

        HashMap<String, ArrayList<String>> hs = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] sArr = strs[i].toCharArray();
            Arrays.sort(sArr);
            String str = String.valueOf(sArr);

            if (!hs.containsKey(str)) {
                hs.put(str, new ArrayList<>());
            }

            hs.get(str).add(strs[i]);
        }

        for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : hs.entrySet()) {
            result.add(stringArrayListEntry.getValue());
        }

        return result;
    }
}