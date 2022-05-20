package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
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

    // 1. for������ Ʈ�� ���� ���Ѵ�. 
    // 2. �״��� while true�� ���ΰ� 
    // 3. time ++ �� �ð��� �� �κп��� ������Ų��. 
    // 4. �������� ������ Ʈ�� �ٸ��� �ö�Ÿ�� �ٸ� Ʈ�� ���� �� ��ŭ �����ְ� �����Ѵ�. 

    // 2Ʈ
    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int seconds = 0 ;
        int sumWeight = 0;

        boolean bridgePassedFlag = true;

        Queue<Integer> waitTruck = new LinkedList<>();
       

        // ��� ť�� �Է�
        for (int i = 0; i < truck_weights.length; i++) {
            waitTruck.add(truck_weights[i]);
        }
        

        

        return answer;
    }


    // 1Ʈ
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;


        int seconds = 0 ;
        int sumWeight = 0;
        boolean bridgePassedFlag = true;

        Queue<Integer> waitTruck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        // ��� ť�� �Է�
        for (int i = 0; i < truck_weights.length; i++) {
            waitTruck.add(truck_weights[i]);
        }
        

        // Ʈ�� IN  / Ʈ�� OUT / Ʈ�� MOVE �� 3������ ���ÿ� 1�ʿ� ����Ǿ����.  
        // Ʈ�� 1���� ���԰� ���� ������ �ٸ��� �������� ������ ��� ī������ ������ �Ǿ���ϱ⶧���� while�� Ȱ��
        
        
        while(waitTruck.size() != 0 && bridge.size() != 0) {            // ���� �ٸ��� Ʈ���� ������ ����.

            int enterTruck = waitTruck.peek();      // ������� �Ǿ��� Ʈ���� �����´�. 
            // 7, 4, 5, 6
            // �ٸ� ���� ���� ���� �� Ȯ������
            if (bridge.size() < bridge_length) {

                // �ٸ� ���� ���� �� �߷� Ȯ�� ����
                if (sumWeight + enterTruck <= weight) {

                    bridge.add(enterTruck);

                    sumWeight += enterTruck;
                } else {
                    // ������ �ٸ��� ���԰� �� �����´�. 
                    // ���԰� 7�� Ʈ�� 1���� 2ĭ�� �ٸ��� �ǳʾ��Ѵ�. 
                    // �ٸ����� ������������ �ð����� ���Ѵ�.

                     
                    if(bridgePassedFlag) {
                        seconds += bridge_length-bridge.size();
                        bridgePassedFlag = false;
                    }
                    
                }

            } else {
                int outTruck = bridge.poll();
                if (outTruck != 0) {
                    sumWeight -= outTruck;
                }
            }

            seconds++;

            // �ٸ��� ���� �ƹ��͵� ���� ��� �����Ѵ�. 
            if (bridge.size() == 0) {
                break;
            }

        }
        
        // Ʈ�� ��� ť �ϳ����� / Ʈ�� �� �긴�� ť�ϳ� �Ἥ 
        // ���ϵ����� �Ѵ� ������ ���̸� ������ ������.
       
        
        

        return answer;
    }

    /***************************************************************************/

}

