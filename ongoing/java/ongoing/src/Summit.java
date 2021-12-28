package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Summit {
    
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
     * ���� ���� ��ũ : 
     *      1. https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%95%A8%EB%B2%94-JAVA%EC%9E%90%EB%B0%94
     * 
     * @param clothes
     * @return int
     */

     // ���� ��~
     public int[] solution2(String[] genres, int[] plays) {
        
        
        // 1. ���� ���� 2�� Ȯ��
        // ����~

        // 2. �帣 / ���Ƚ�� / ������ȣ�� DTO�� ����
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

        // 3. �帣 / �� ���Ƚ�� ����Ʈ 
        HashMap<String, Integer> allPlay = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            allPlay.put(genres[i], allPlay.getOrDefault(genres[i], 0)+plays[i]);
        }


        // 3. �帣�� ���� ����Ʈ ����� 
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

        // MusicInfo List ����� 
        List<MusicInfo> musicInfoDtoList = new ArrayList<>();
        for(int i = 0; i < genres.length; i++) {
            MusicInfo m = new MusicInfo(i, genres[i], plays[i]);
            musicInfoDtoList.add(m);
        }
        
        // 4. �帣�� 1�� 2�� ���ϱ� 
        ArrayList<Integer> answerLIst = new ArrayList<>();

        for(String genre : genre_orderbyLIst){
            int first_id = -1;
            int first_value = 0;
            int second_id = -1;
            int second_value = 0;

            for (MusicInfo action : musicInfoDtoList) {

                if(genre.compareTo(action.genre) == 0) {     // a �帣�鳢�� �� 

                    if(action.play > first_value){
                        second_id = first_id;           // ���� ū���� ����ɶ� ���� ����ū���� 2���� �з����Ѵ�. 
                        second_value = first_value;

                        first_id = action.id;   
                        first_value = action.play;

                    } else if (action.play > second_value) {
                        second_id = action.id;
                        second_value = action.play;
                    }
                }
            }

            // �帣�� �Ѱ �����Ұ�� 
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

        // 4. 1�� 2���� ���Ƚ���� ���� ��� ������ȣ�� �����ϱ� 
        // 5. int �迭�� �����Ͽ� ���� 

        int[] answer = new int[answerLIst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLIst.get(i);
        }
        
        return answer;
    }

    ///////////////////////////////// ������ ^^;;
    public int[] solution3(String[] genres, int[] plays) {
        
        // �帣, ���Ƚ��, ������ȣ�� ��� DTO Ŭ���� ����
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


        // map�� �帣, ����� �� key value �� ����
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<genres.length; i++){
                map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
            }


            
            // 1. �帣 ����
            ArrayList<String> genres_ordered = new ArrayList<>();   // �帣�� ������ ��� arrayList 

            while(map.size()!=0){           // map�� �������� while�� ��ȸ 
                int max = -1;               
                String max_key = "";        

        // ["classic", "pop", "classic", "classic", "pop"]   
        //	[500,       600,    150,        800,     2500]

                for(String key : map.keySet()){     // map�� Ű-> ����帣��� for�� ���� 
                    int tmp_cnt = map.get(key);     // �ش� �帣�� ������� �ӽ�����

                    if(tmp_cnt>max){                // ������� max�� �� 
                        max = tmp_cnt;              // ũ�� max ���� ���� 
                        max_key = key;              // max�� �帣�� ���� 
                    }
                }
                genres_ordered.add(max_key);        // �ش� ����ū �帣�� �߰���
                map.remove(max_key);                // map�� ������ ��. 
            }
            
            // 2. �帣 �� �뷡 ����
            ArrayList<Music2> result = new ArrayList<>();
            for(String gern : genres_ordered){
                ArrayList<Music2> list = new ArrayList<>();
                for(int i=0; i<genres.length; i++){
                    if(genres[i].equals(gern)){
                        list.add(new Music2(gern, plays[i], i));
                    }
                }
                Collections.sort(list, (o1, o2) -> o2.play - o1.play); // �������� ����
                result.add(list.get(0)); 	// 1���� ������ ����
                if(list.size()!=1){ 	// �� ������ ���� ������(==�帣 ���� �뷡�� 1������ ������) ����
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