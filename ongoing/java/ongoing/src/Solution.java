package ongoing.java.ongoing.src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /*************************   Programmers 문제   ***************************/

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



    /**
     * 해시문제 - "베스트앨범"
     * https://programmers.co.kr/learn/courses/30/lessons/42579
     * 
     * @param clothes
     * @return int
     */

    public int[] solution2(String[] genres, int[] plays) {
        int[] answer = {};

        // 1. 장르의 종류를 구함
        Set<String> genreSet = new HashSet<>();
        for(String str : genres) {
            genreSet.add(str);      // 중복제거
        }

        // 2. 장르와 횟수를 고유번호순서로 hashMap 몰아서 저장 
        HashMap<String, Integer> genrePlay = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlay.put(genres[i], plays[i]);
        }

        // 각 장르별로 for문 조회
        for(String genre : genreSet) {
            
            if (genrePlay.containsKey(genre)) {

            }
            
        }

       
        HashMap<String, Integer> top2TempList = new HashMap<>();

        

        // 인덱스가 고유번호이기때문에 임시로 저장하여 활용한다. 
        
        

        for(  ) {

        }

        // 2. 장르별 조회수가 높은 2곡을 조회 및 저장
        // 3. 장르별 가장 조회수가 높은 곡들을 나열 
        





        
        // 1. 장르별에서 조회수 높은 것들을 가져와 비교 -> 조회수가 가장높은 곡을 포함한 장르순서 저장
        // 2. 각 장르별 조회수 높은 2곡을 순서대로 저장. 조회수가 같을 경우 고유번호로 나열.

        return answer;
    }

    

    /***************************************************************************/

}




// /**
// 	 * 사업자번호 유효성검사를 한다.
// 	 * @param registrationNo
// 	 * @return boolean
// 	 */
// 	public static boolean checkRegistrationNo(String registrationNo) {
// 		return (Pattern.matches("\\d{3}\\d{2}\\d{5}$", registrationNo));
// 	}