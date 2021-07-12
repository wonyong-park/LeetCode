class Solution {
    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        if (n == 1) return new int[]{0,1};

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            int count = 0;
            int k = i;

            while(k  != 0){
                if(k%2 == 1) count++;
                k/=2;
            }
            arr[i] = count;
        }

        return arr;
    }
}