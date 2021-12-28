package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Summit {
    
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
     * 정답 참고 링크 : 
     *      1. https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%95%A8%EB%B2%94-JAVA%EC%9E%90%EB%B0%94
     * 
     * @param clothes
     * @return int
     */

     // 도전 중~
     public int[] solution2(String[] genres, int[] plays) {
        
        
        // 1. 문제 정독 2번 확인
        // 읽음~

        // 2. 장르 / 재생횟수 / 고유번호를 DTO에 저장
        class MusicInfo {
            private int id;
            private String genre;
            private int play;

            public MusicInfo(int id, String genre, int play){
                this.id = id;
                this.genre = genre;
                this.play = play;
            }
        }

        // 3. 장르 / 총 재생횟수 리스트 
        HashMap<String, Integer> allPlay = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            allPlay.put(genres[i], allPlay.getOrDefault(genres[i], 0)+plays[i]);
        }


        // 3. 장르별 순위 리스트 만들기 
        ArrayList<String> genre_orderbyLIst = new ArrayList<>();
        while(allPlay.size() != 0) {
            int max_play = -1;
            String max_genre = "";            
            for(String genre : allPlay.keySet()){
                if(allPlay.get(genre) > max_play) {
                    max_genre = genre;
                    max_play = allPlay.get(genre);
                }
            }
            genre_orderbyLIst.add(max_genre);
            allPlay.remove(max_genre);
        }

        // MusicInfo List 만들기 
        List<MusicInfo> musicInfoDtoList = new ArrayList<>();
        for(int i = 0; i < genres.length; i++) {
            MusicInfo m = new MusicInfo(i, genres[i], plays[i]);
            musicInfoDtoList.add(m);
        }
        
        // 4. 장르내 1위 2위 구하기 
        ArrayList<Integer> answerLIst = new ArrayList<>();

        for(String genre : genre_orderbyLIst){
            int first_id = -1;
            int first_value = 0;
            int second_id = -1;
            int second_value = 0;

            for (MusicInfo action : musicInfoDtoList) {

                if(genre.compareTo(action.genre) == 0) {     // a 장르들끼리 비교 

                    if(action.play > first_value){
                        second_id = first_id;           // 가장 큰값에 변경될때 현재 가장큰값이 2위로 밀려야한다. 
                        second_value = first_value;

                        first_id = action.id;   
                        first_value = action.play;

                    } else if (action.play > second_value) {
                        second_id = action.id;
                        second_value = action.play;
                    }
                }
            }

            // 장르에 한곡만 존재할경우 
            if(second_id == -1) {
                answerLIst.add(first_id);
            } else {
                if(first_value == second_value){
                    if(first_id > second_id) {
                        answerLIst.add(second_id);
                        answerLIst.add(first_id);
                    } else {
                        answerLIst.add(first_id);
                        answerLIst.add(second_id);
                    }
                } else{
                    answerLIst.add(first_id);
                    answerLIst.add(second_id);
                }
            }
        }        

        // 4. 1위 2위가 재생횟수가 같을 경우 고유번호로 정렬하기 
        // 5. int 배열에 저장하여 리턴 

        int[] answer = new int[answerLIst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLIst.get(i);
        }
        
        return answer;
    }

    ///////////////////////////////// 정답지 ^^;;
    public int[] solution3(String[] genres, int[] plays) {
        
        // 장르, 재생횟수, 고유번호를 담는 DTO 클래스 생성
        class Music2{
            private String genre;
            private int play;
            private int idx;
    
            public Music2(String genre, int play, int idx) {
                this.genre = genre;
                this.play = play;
                this.idx = idx;
            }
        }


        // map에 장르, 재생수 로 key value 로 저장
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<genres.length; i++){
                map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
            }


            
            // 1. 장르 선정
            ArrayList<String> genres_ordered = new ArrayList<>();   // 장르별 순서를 담는 arrayList 

            while(map.size()!=0){           // map을 기준으로 while문 순회 
                int max = -1;               
                String max_key = "";        

        // ["classic", "pop", "classic", "classic", "pop"]   
        //	[500,       600,    150,        800,     2500]

                for(String key : map.keySet()){     // map의 키-> 모든장르들로 for문 실행 
                    int tmp_cnt = map.get(key);     // 해당 장르의 재생수를 임시저장

                    if(tmp_cnt>max){                // 재생수와 max와 비교 
                        max = tmp_cnt;              // 크면 max 값에 저장 
                        max_key = key;              // max의 장르를 저장 
                    }
                }
                genres_ordered.add(max_key);        // 해당 가장큰 장르를 추가함
                map.remove(max_key);                // map에 삭제를 함. 
            }
            
            // 2. 장르 내 노래 선정
            ArrayList<Music2> result = new ArrayList<>();
            for(String gern : genres_ordered){
                ArrayList<Music2> list = new ArrayList<>();
                for(int i=0; i<genres.length; i++){
                    if(genres[i].equals(gern)){
                        list.add(new Music2(gern, plays[i], i));
                    }
                }
                Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅
                result.add(list.get(0)); 	// 1개는 무조건 수록
                if(list.size()!=1){ 	// 더 수록할 곡이 있으면(==장르 내의 노래가 1개보다 많으면) 수록
                    result.add(list.get(1));
                }
            }
            
            // print result
            int[] answer = new int[result.size()];
            for(int i=0; i<result.size(); i++){
                answer[i] = result.get(i).idx;
            }
            return answer;
    }




    

}