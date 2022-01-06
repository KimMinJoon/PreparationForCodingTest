package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /*************************   진행 중인 Programmers 문제   ***************************/
    /**
     * 스택 / 큐 - "프린터"
     * https://programmers.co.kr/learn/courses/30/lessons/42587
     * 
     * 
     * @param priorities 
     * @param location
     * @return int  
     */

     
    // 다시 reset 도전 해보자 
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 1. 현재 priorities 의 배열 index가 현재 location 이기 때문에, 
        //    우선순위와 위치를 함께 저정하여 기존의 입력된 location을 탐색해야한다.
        // 1-2. task 클래스 생성
        
        ArrayList<Integer> prio_order_by = new ArrayList<>();

        Queue<Task> taskQueue = new LinkedList<>();

        // 2. priority값과 location값을 가진 task를 taskList 큐에 담는다. 
        for (int i = 0; i < priorities.length; i++) {
            Task task = new Task();
            task.location = i;
            task.priority = priorities[i];
            prio_order_by.add(priorities[i]);
            taskQueue.add(task);
        }

        // 3. priorities 배열의 우선순위 순으로 모두 나열한다. (중복제거하지않아야함)
        prio_order_by.sort(Comparator.reverseOrder());

        

        // 4. taskList 큐를 돌면서 조건에 우선순위가 가장 높은지 탐색하여 찾으면 제거(프린팅 확정이기에 cnt를 증가)
        //    하고 아니면 큐에 재등록한다. 
        int idx = 0;
        while (!taskQueue.isEmpty()) {
            Task temp = taskQueue.poll();
            if (temp.priority != prio_order_by.get(idx)) {
                taskQueue.offer(temp);               
            } else {
                answer++;
                idx++;
                if (location == temp.location) {
                    break;
                }
            }
        }


        // 5. 제거 될 때, 입력된 location과 동일한지 확인하여 동일하다면 해당 cnt를 반환


        return answer;
    }

    static class Task{
        private int priority;
        private int location;
        // private int order;

        public int getPriority() {
            return this.priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getLocation() {
            return this.location;
        }

        public void setLocation(int location) {
            this.location = location;
        }
    }


    /***************************************************************************/

}

