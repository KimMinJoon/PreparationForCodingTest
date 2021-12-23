package ongoing.java.ongoing.src;

import java.util.HashMap;

class Solution {
    
    /**
     * 해시문제 - "위장"
     * https://programmers.co.kr/learn/courses/30/lessons/42577
     * 
     * @param clothes
     * @return int
     */

    public int solution1(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> m = new HashMap<>();
        
        // 1. 각각의 의상의 종류의 개수를 구하여 map에 저장
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];         // 두번째 인덱스가 키니까 1을 가져온다.
            if(!m.containsKey(key)){
                m.put(key, m.getOrDefault(key, 1));
            } else {
                m.put(key, m.get(key)+1);
            }
        }

        // 2. 의상의 종류만 착용하는 경우 
        for(String key : m.keySet()) {
            answer *=  m.get(key) + 1;      // +1의 이유는 안입는 경우를 추가한것.
        }

        // 3. 전부다 안입는 경우 1을 빼주고 리턴.
        return answer - 1; 
    }
}