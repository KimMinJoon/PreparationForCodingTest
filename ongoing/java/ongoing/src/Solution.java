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

     // 도전 중~
     public int solution(int[] priorities, int location) {
        int answer = 0;

        // 프린터의 고유 기능 
        // 큐로 저장이 되어있는 대기목록 
        // 우선순위 탐색 후 큐에 다시 삽입 
        
        // 1. 큐를 활용하여 알고리즘을 설계한다. 
        Queue<Task> q = new LinkedList<>();



        // 2. Task class 에 우선순위와 위치를 저장한다.
        // 입력된 location과 큐를 돌면서 기존의 위치와 비교해야되기때문에?

        ArrayList<Integer> prio_list = new ArrayList<>();

        for(int i = 0; i < priorities.length; i++){
            Task task = new Task();
            task.location = i;
            task.priority = priorities[i];
            prio_list.add(task.priority);
            q.offer(task);
        }
        
        prio_list.sort(Comparator.reverseOrder());

        //중복 제거 
        ArrayList<Integer> prioListSet = new ArrayList<>();
        
        for (int i = 0; i < prio_list.size()-1; i++) {
            if(!prioListSet.contains(prio_list.get(i))){
                prioListSet.add(prio_list.get(i));
            }
        }
        
        System.out.println("prio_list.size() :::: " + prio_list.size());
        System.out.println("prioListSet :::: " + prioListSet.size());

        int cnt = 1;                                // 프린트 순서의 첫번째는 1부터 시작.
        int temp_prio = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            
            Task temp_task = q.poll();                  // 큐에서 빼고 삭제 

            

            if (temp_task.priority < prioListSet.get(idx)) {       // 다시 큐에 넣기     
                q.offer(temp_task);

            } else {                                    // 큐에서 제거하면서 cnt 증가

                if(temp_prio != temp_task.priority){
                    temp_prio = temp_task.priority;
                    idx++;
                }
                
                if (location == temp_task.location) {
                    answer = cnt;
                    break;
                }
                cnt++ ;                         // 이거 카운트 될 때 중복되는 우선순위들 
            }

            
        }

        

        // [2, 1, 3, 2] -> 2 -> return 1

        // 1. for문 돌면서 큐로 우선순위가 높은거 먼저 peek
        // 2. for문의 index가 초기화? 되니까 


        // 3. 큐를 돌면서 해당 location과 같으면 cnt 값을 리턴한다. 


        return answer;
    }

    // 다시 reset 도전 해보자 
    // public int solution2(int[] priorities, int location) {


    // }

    static class Task{
        private int priority;
        private int location;
        private int order;

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

        public int getOrder() {
            return this.order;
        }
        
        public void setOrder(int order) {
            this.order = order;
        }
    }


    /***************************************************************************/

}

