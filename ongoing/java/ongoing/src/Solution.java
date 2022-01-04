package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /*************************   ���� ���� Programmers ����   ***************************/
    /**
     * ���� / ť - "������"
     * https://programmers.co.kr/learn/courses/30/lessons/42587
     * 
     * 
     * @param priorities 
     * @param location
     * @return int  
     */

     // ���� ��~
     public int solution(int[] priorities, int location) {
        int answer = 0;

        // �������� ���� ��� 
        // ť�� ������ �Ǿ��ִ� ����� 
        // �켱���� Ž�� �� ť�� �ٽ� ���� 
        
        // 1. ť�� Ȱ���Ͽ� �˰����� �����Ѵ�. 
        Queue<Task> q = new LinkedList<>();



        // 2. Task class �� �켱������ ��ġ�� �����Ѵ�.
        // �Էµ� location�� ť�� ���鼭 ������ ��ġ�� ���ؾߵǱ⶧����?

        ArrayList<Integer> prio_list = new ArrayList<>();

        for(int i = 0; i < priorities.length; i++){
            Task task = new Task();
            task.location = i;
            task.priority = priorities[i];
            prio_list.add(task.priority);
            q.offer(task);
        }
        
        prio_list.sort(Comparator.reverseOrder());
        int cnt = 1;                                // ����Ʈ ������ ù��°�� 1���� ����.
        while (!q.isEmpty()) {
            for (Integer high_prio: prio_list) {         // ���� �������� 3 ���� -> 1���� 
                Task temp_task = q.poll();                  // ť���� ���� ���� 
                
                if (temp_task.priority < high_prio) {       // �ٽ� ť�� �ֱ�
                    q.offer(temp_task);
                } else {                                    // ť���� �����ϸ鼭 cnt ����
                    if (location == temp_task.location) {
                        answer = cnt;
                    }
                    cnt++ ;
                }
            }
        }

        

        // [2, 1, 3, 2] -> 2 -> return 1

        // 1. for�� ���鼭 ť�� �켱������ ������ ���� peek
        // 2. for���� index�� �ʱ�ȭ? �Ǵϱ� 


        // 3. ť�� ���鼭 �ش� location�� ������ cnt ���� �����Ѵ�. 


        return answer;
    }

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

