class Solution {
    public int countSubstrings(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String nonReverse = s.substring(i, j);
                StringBuilder sb = new StringBuilder(s.substring(i, j)).reverse();
                
                if (nonReverse.equals(sb.toString())) {
                    count++;
                }
                
            }
        }
        
        return count;
    }
}