class Solution {
        public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            //숫자인경우
            if (Character.isDigit(s.charAt(i))) {
                int startIndex = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int endIndex = i--;
                numStack.add(Integer.parseInt(s.substring(startIndex, endIndex)));
            } else if (Character.isAlphabetic(s.charAt(i))) {
                if (numStack.size() > 0) {
                    charStack.add(s.charAt(i));
                }
                else{
                    result.append(s.charAt(i));
                }

            } else if(s.charAt(i) == '['){
                charStack.add(s.charAt(i));
            } else {
                StringBuilder temp = new StringBuilder();
                while (!charStack.isEmpty()) {
                    char pop = charStack.pop();
                    if (pop == '[') {
                        break;
                    }
                    temp.append(pop);
                }

                temp = temp.reverse();
                int num = numStack.pop();
                for (int j = 0; j < num; j++) {
                    if (!charStack.isEmpty()) {
                        for (int k = 0; k < temp.length(); k++) {
                            charStack.add(temp.charAt(k));
                        }
                    }else{
                        result.append(temp);
                    }
                }
            }
        }

        return result.toString();
    }

}