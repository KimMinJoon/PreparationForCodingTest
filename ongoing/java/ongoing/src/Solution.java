package ongoing.java.ongoing.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    /*************************   ���� ���� Programmers ����   ***************************/

    /**
     * ����/ť - "��ɰ���"
     *  https://programmers.co.kr/learn/courses/30/lessons/42586
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

            // (int) Math.ceil(remain); ������ �߻��� �ø�ó���� ��ü����.
            int day = (100 - progresses[i] ) / speeds[i];           // �� �κ��� ��¥�� ���ϱ������� 
                                                                    // ���� ���� ���������� +1�� ������ ����..
                                                                    
            // while ���� Ȱ���Ͽ� ��¥�� �ʰ����� �׽�Ʈ�Ͽ� �����ǰԲ��Ѵٸ� �ٸ� ���ǿ��� 
            // Ȱ���� �� �־���. 

            // ���� �ش� ������ ó���ӵ� �� ���� �ҿ�Ǵ� �ϼ��� ���Ͽ� ������ �ʿ䰡 ������.


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






    //// ���� 
    // https://techhan.github.io/algorithm/programmers-55/
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];          // int �� �迭 ���� 

        int day = -1;           // ����?

        // [93, 30, 55]	[1, 30, 5]	[2, 1]


        for(int i=0; i<progresses.length; i++) {        // 93, 30, 55 ��ŭ �ݺ�

            while(progresses[i] + (day*speeds[i]) < 100) {      // �ҿ����ڸ� ���ϰ� �ݺ�����
                day++;          // 0 -> ... -> 7
            }

            dayOfend[day]++;            // [7] ��° �ε����� 1 �ö�
        }
        
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
        // 
    }

    // ť�� �̿��� Ǯ��
    public int[] solution3(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();      // ť�� Ȱ���� ��ũ�� ����Ʈ ���� .

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {

            double remain = (100 - progresses[i]) / (double) speeds[i];

            int date = (int) Math.ceil(remain);         // i��° �ҿ�Ǵ� �ϼ��� ����. 7��

            if (!q.isEmpty() && q.peek() < date) {      // 7 < 3 , 7 < 9
                answerList.add(q.size());                   // 7, 3 �� ť�� �ֱ⶧���� 2�� ����
                q.clear();                                  // ���� 
            }

            q.offer(date);                      // ù��° ��ҿ� 7�� ���� -> 3 ���� -> ������� 9�� ����(ù��°�ε�����)
        }

        answerList.add(q.size());               // �������� �ٵ��� ť�� ������ �߰����ֱ� 

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }



    /***************************************************************************/

}

