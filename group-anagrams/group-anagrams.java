class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visted = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if(!visted[i]){
                List<String> list = new ArrayList<>();
                String str = strs[i];
                list.add(str);
                visted[i] = true;

                for (int j = i+1; j < strs.length; j++) {
                    String str2 = strs[j];
                    //같은 경우
                    if(anagrams(str, str2)){
                        list.add(str2);
                        visted[j] = true;
                    }
                }

                result.add(list);
            }
        }

        return result;
    }

    private boolean anagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }
}