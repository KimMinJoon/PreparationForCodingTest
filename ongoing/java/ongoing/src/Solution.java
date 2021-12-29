package ongoing.java.ongoing.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

    /*************************   ���� ���� Programmers ����   ***************************/

    /**
     * �ؽù��� - "����"
     * 
     * 
     * @param clothes
     * @return int
     */


    public int[] solution(int[] progresses, int[] speeds) {
       

        // 1. ���� 2�� �б� 

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

        // 2. ������ ���α׷����� �ҿ� ���ڸ� ���Ѵ�. 
        
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



    /***************************************************************************/

}

