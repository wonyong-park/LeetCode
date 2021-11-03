class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] alpabets = new int[26];
        int max = 0;
        int index = 0;

        for (char task : tasks) {
            alpabets[task - 'A']++;
            if (alpabets[task - 'A'] > max) {
                max = alpabets[task - 'A'];
                index = task - 'A';
            }
        }

        int idleSize = (max - 1) * n;

        for (int i = 0; i < alpabets.length; i++) {
            if(index == i || alpabets[i] == 0) continue;

            idleSize -= Math.min(max - 1, alpabets[i]);
        }

        return idleSize > 0 ? idleSize + tasks.length : tasks.length;
    }

}