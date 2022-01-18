package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /*************************   ���� ���� Programmers ����   ***************************/
    
    /**
     * ���� / ť - �ٸ��� ������ Ʈ��
     * https://programmers.co.kr/learn/courses/30/lessons/42583
     * 
     * @param bridge_length
     * @param weight
     * @param truck_weights
     * @return
     */


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 1. ť�� Ʈ�� ���� ������� �ִ´�.
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int sum_weight = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }

        int truck_in_brige = trucks.poll();
        int bridg_size = 0;
        
        while (!trucks.isEmpty()) {
            

            // �긮�� ť�� �ֱ� 
            if (bridg_size < bridge_length) {
                if (sum_weight + truck_in_brige < weight) {  
                    bridge.add(truck_in_brige);
                    sum_weight += truck_in_brige;
                    answer++;
                } else {
                    bridg_size++;
                    answer++;
                }
            } else {
                bridge.poll();
                answer++;

            }

        }

       
        
        // 2. ť�� ������ ��, ���� ���ǿ� ���������� 0�� ť�� �ִ´�. 

        // 3. ť���� ���� ť�� ���������� ī������ �Ѵ�. 

        // 4. ť�� ������� ī������ ���� �����Ѵ�.



        

        return answer;
    }

    /***************************************************************************/

}

