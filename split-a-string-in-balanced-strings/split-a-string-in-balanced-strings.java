class Solution {
    static public int balancedStringSplit(String s) {
        int Lcnt = 0, Rcnt = 0, cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'L'){
				Lcnt++;
			}else{
				Rcnt++;
			}
			
			if(Lcnt == Rcnt) cnt++;
		}
        
        return cnt;
    }
}