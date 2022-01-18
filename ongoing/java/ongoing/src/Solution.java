package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /*************************   진행 중인 Programmers 문제   ***************************/
    
    /**
     * 스택 / 큐 - 다리를 지나는 트럭
     * https://programmers.co.kr/learn/courses/30/lessons/42583
     * 
     * @param bridge_length
     * @param weight
     * @param truck_weights
     * @return
     */


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 1. 큐에 트럭 무게 순서대로 넣는다.
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int sum_weight = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }

        int truck_in_brige = trucks.poll();
        int bridg_size = 0;
        
        while (!trucks.isEmpty()) {
            

            // 브리지 큐에 넣기 
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

       
        
        // 2. 큐에 삽입할 때, 무게 조건에 맞지않을때 0을 큐에 넣는다. 

        // 3. 큐에서 꺼내 큐에 꺼낼때마다 카운팅을 한다. 

        // 4. 큐가 비었을때 카운팅한 수를 리턴한다.



        

        return answer;
    }

    /***************************************************************************/

}

