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

     
    // �ٽ� reset ���� �غ��� 
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 1. ���� priorities �� �迭 index�� ���� location �̱� ������, 
        //    �켱������ ��ġ�� �Բ� �����Ͽ� ������ �Էµ� location�� Ž���ؾ��Ѵ�.
        // 1-2. task Ŭ���� ����
        
        ArrayList<Integer> prio_order_by = new ArrayList<>();

        Queue<Task> taskQueue = new LinkedList<>();

        // 2. priority���� location���� ���� task�� taskList ť�� ��´�. 
        for (int i = 0; i < priorities.length; i++) {
            Task task = new Task();
            task.location = i;
            task.priority = priorities[i];
            prio_order_by.add(priorities[i]);
            taskQueue.add(task);
        }

        // 3. priorities �迭�� �켱���� ������ ��� �����Ѵ�. (�ߺ����������ʾƾ���)
        prio_order_by.sort(Comparator.reverseOrder());

        

        // 4. taskList ť�� ���鼭 ���ǿ� �켱������ ���� ������ Ž���Ͽ� ã���� ����(������ Ȯ���̱⿡ cnt�� ����)
        //    �ϰ� �ƴϸ� ť�� �����Ѵ�. 
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


        // 5. ���� �� ��, �Էµ� location�� �������� Ȯ���Ͽ� �����ϴٸ� �ش� cnt�� ��ȯ


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

