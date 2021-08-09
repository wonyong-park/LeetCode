class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.empty() && temperatures[i] > temperatures[st.peek()]) {
                result[st.peek()] = i - st.pop();
            }
            st.push(i);
        }

        return result;
    }
}