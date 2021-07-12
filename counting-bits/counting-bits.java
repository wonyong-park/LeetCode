class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n + 1];
        int standard = 1;
        for (int i = 1; i <= n ; i++) {
            if(standard * 2 == i){
                standard = i;
            }
            arr[i] = arr[i - standard] + 1;
        }

        return arr;
    }
}