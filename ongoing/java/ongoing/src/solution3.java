package ongoing.java.ongoing.src;

import java.util.HashMap;

class Solution {
    
    /**
     * �ؽù��� - "����"
     * https://programmers.co.kr/learn/courses/30/lessons/42577
     * 
     * @param clothes
     * @return int
     */

    public int solution1(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> m = new HashMap<>();
        
        // 1. ������ �ǻ��� ������ ������ ���Ͽ� map�� ����
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];         // �ι�° �ε����� Ű�ϱ� 1�� �����´�.
            if(!m.containsKey(key)){
                m.put(key, m.getOrDefault(key, 1));
            } else {
                m.put(key, m.get(key)+1);
            }
        }

        // 2. �ǻ��� ������ �����ϴ� ��� 
        for(String key : m.keySet()) {
            answer *=  m.get(key) + 1;      // +1�� ������ ���Դ� ��츦 �߰��Ѱ�.
        }

        // 3. ���δ� ���Դ� ��� 1�� ���ְ� ����.
        return answer - 1; 
    }
}