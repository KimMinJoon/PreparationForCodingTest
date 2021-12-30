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
            int day = (100 - progresses[i] ) / speeds[i];
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

        int day = -1;

        // [93, 30, 55]	[1, 30, 5]	[2, 1]
        for(int i=0; i<progresses.length; i++) {        // 93, 30, 55 만큼 반복

            while(progresses[i] + (day*speeds[i]) < 100) {      // 소요일자를 구하고 반복종료
                day++;          // 0 -> ... -> 7
            }

            dayOfend[day]++;            // [7] 번째 인덱스에 1 올라감
        }
        
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    // 큐를 이용한 풀이
    public int[] solution3(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }



    /***************************************************************************/

}

