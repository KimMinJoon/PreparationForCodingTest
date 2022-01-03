package ongoing.java.ongoing.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    /*************************   진행 중인 Programmers 문제   ***************************/

    /**
     * 스택/큐 - "기능개발"
     *  https://programmers.co.kr/learn/courses/30/lessons/42586
     * 
     * @param clothes
     * @return int
     */


    public int[] solution(int[] progresses, int[] speeds) {
       

        // 1. 문제 2번 읽기 

        class Task {
            int progress;
            int speed;
            int day;

            public Task(int progress, int speed, int day){
                this.progress = progress;
                this.speed = speed;
                this.day = day;
            }
        }

        // 2. 각각의 프로그래스의 소요 일자를 구한다. 
        
        List<Task> taskDtoList = new ArrayList<>();
        
        int[] days = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++) {

            // (int) Math.ceil(remain); 나머지 발생시 올림처리로 대체가능.
            int day = (100 - progresses[i] ) / speeds[i];           // 이 부분이 날짜를 구하긴하지만 
                                                                    // 나눈 몫의 나머지까지 +1을 더하지 않음..
                                                                    
            // while 문을 활용하여 날짜가 초과됨을 테스트하여 누적되게끔한다면 다른 조건에도 
            // 활용할 수 있었다. 

            // 굳이 해당 과정과 처리속도 에 따른 소요되는 일수를 구하여 저장할 필요가 없었다.


            days[i] = day;
            taskDtoList.add(new Task(progresses[i], speeds[i], day));
        }


        int submitCnt = 1;
        int compareDay = 0;
        ArrayList<Integer> answerList = new ArrayList<>();
            // 0 7 4 9 
        
        for(int i = 0; i < taskDtoList.size(); i++){
            if(taskDtoList.get(i).day > compareDay) {     // 9 > 7

                if(compareDay != 0){
                    answerList.add(submitCnt);
                }

                compareDay = taskDtoList.get(i).day;      // 0 = 7 
                submitCnt = 1;

            } else {
                submitCnt++;
            }

            if(taskDtoList.size()-1 == i){
                answerList.add(submitCnt);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }






    //// 정답 
    // https://techhan.github.io/algorithm/programmers-55/
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];          // int 형 배열 선언 

        int day = -1;           // 굳이?

        // [93, 30, 55]	[1, 30, 5]	[2, 1]


        for(int i=0; i<progresses.length; i++) {        // 93, 30, 55 만큼 반복

            while(progresses[i] + (day*speeds[i]) < 100) {      // 소요일자를 구하고 반복종료
                day++;          // 0 -> ... -> 7
            }

            dayOfend[day]++;            // [7] 번째 인덱스에 1 올라감
        }
        
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
        // 
    }

    // 큐를 이용한 풀이
    public int[] solution3(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();      // 큐을 활용한 링크드 리스트 선언 .

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {

            double remain = (100 - progresses[i]) / (double) speeds[i];

            int date = (int) Math.ceil(remain);         // i번째 소요되는 일수를 구함. 7일

            if (!q.isEmpty() && q.peek() < date) {      // 7 < 3 , 7 < 9
                answerList.add(q.size());                   // 7, 3 이 큐에 있기때문에 2가 저장
                q.clear();                                  // 비우기 
            }

            q.offer(date);                      // 첫번째 요소에 7일 저장 -> 3 저장 -> 비워지고 9가 저장(첫번째인덱스임)
        }

        answerList.add(q.size());               // 마지막에 다돌고 큐에 남은거 추가해주기 

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }



    /***************************************************************************/

}

