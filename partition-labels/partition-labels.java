class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] alpabets = new int[26];

        //가장 나중에 나온 알파벳 저장
        for (int i = 0; i < s.length(); i++) {
            int pos = (int) s.charAt(i) - 'a';
            alpabets[pos] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            //현재 알파벳의 가장 마지막 값을 나타내는 end
            int end = alpabets[(int) s.charAt(i) - 'a'];
            int count = 0;

            //현재 알파벳부터 end까지 for문
            for (int j = i; j <= end; j++) {
                //j번째 알파벳의 마지막 등장 값을 가져온 후
                int pos = alpabets[(int) s.charAt(j) - 'a'];
                
                //pos가 end보다 크다면 마지막 값을 나타내는 알파벳의 위치를 변경 
                // end = pos로
                if (pos > end) {
                    end = pos;
                }
                count++;
            }
            // 결과 result 추가
            result.add(count);
            
            // for문이 한번 완료가 되면 ++이 되니까
            // i에 count -1 을 더해줌
            i += count - 1 ;
            
        }

        return result;
    }
}