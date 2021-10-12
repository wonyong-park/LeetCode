class Solution {
    public int numTrees(int n) {

        int[] d = new int[20];
        d[0] = 1; //아무것도 없는 경우도 1개
        d[1] = 1; //1만 있는 경우 1개

        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] += d[j - 1] * d[i - j];
            }
        }

        return d[n];
    }
}