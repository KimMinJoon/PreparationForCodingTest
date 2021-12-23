package ongoing.java.ongoing.src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /*************************   Programmers ����   ***************************/

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



    /**
     * �ؽù��� - "����Ʈ�ٹ�"
     * https://programmers.co.kr/learn/courses/30/lessons/42579
     * 
     * @param clothes
     * @return int
     */

    public int[] solution2(String[] genres, int[] plays) {
        int[] answer = {};

        // 1. �帣�� ������ ����
        Set<String> genreSet = new HashSet<>();
        for(String str : genres) {
            genreSet.add(str);      // �ߺ�����
        }

        // 2. �帣�� Ƚ���� ������ȣ������ hashMap ���Ƽ� ���� 
        HashMap<String, Integer> genrePlay = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlay.put(genres[i], plays[i]);
        }

        // �� �帣���� for�� ��ȸ
        for(String genre : genreSet) {
            
            if (genrePlay.containsKey(genre)) {

            }
            
        }

       
        HashMap<String, Integer> top2TempList = new HashMap<>();

        

        // �ε����� ������ȣ�̱⶧���� �ӽ÷� �����Ͽ� Ȱ���Ѵ�. 
        
        

        for(  ) {

        }

        // 2. �帣�� ��ȸ���� ���� 2���� ��ȸ �� ����
        // 3. �帣�� ���� ��ȸ���� ���� ����� ���� 
        





        
        // 1. �帣������ ��ȸ�� ���� �͵��� ������ �� -> ��ȸ���� ������� ���� ������ �帣���� ����
        // 2. �� �帣�� ��ȸ�� ���� 2���� ������� ����. ��ȸ���� ���� ��� ������ȣ�� ����.

        return answer;
    }

    

    /***************************************************************************/

}




// /**
// 	 * ����ڹ�ȣ ��ȿ���˻縦 �Ѵ�.
// 	 * @param registrationNo
// 	 * @return boolean
// 	 */
// 	public static boolean checkRegistrationNo(String registrationNo) {
// 		return (Pattern.matches("\\d{3}\\d{2}\\d{5}$", registrationNo));
// 	}