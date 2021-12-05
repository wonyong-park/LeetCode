class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterArray = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        comb("", digits, 0, res, letterArray);
        return res;
    }

    public void comb(String pre, String digits, int length, List<String> res, String[] letterArray) {
        //추가조건
        if (length >= digits.length()) {
            res.add(pre);
            return;
        }

        String letters = letterArray[digits.charAt(length) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            comb(pre + letters.charAt(i), digits, length + 1, res, letterArray);
        }
    }
}