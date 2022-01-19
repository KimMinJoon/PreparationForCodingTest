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

    // �� �ٸ��� ť��� �����ϰ� ���ǿ� �ȸ����� 0�� �ְ� �ʸ� �ø��� ���������� ���Ҵ�.
    // �ٵ� �ٸ��� �����ϰ����ϴ� Ʈ���迭�� �������� �ݺ��ؼ� ���°� �±��ߴµ� 
    // �ʸ� �� ��, while�� ���μ� ť���� �о�⸦ �ؾ��Ѵٴ� ������ ���� ����.
    // �ͱ�?
    // �ݺ����� �Ⱦ������ߴ��Ͱ���. 
    // ��? �õ��� �������� �ʾ����� ��������. ������� ����ϸ� ������ ���� �غ��� 2�� 3�� 4�߱��� ��� ����� �����ҵ�
    // �׸��� ����ð� �ʰ��Ǹ� �׶����� �����ϴ°� �´ٺ�.
    // �ʹ� �Ѳ����� �������� �ϴٰ� ���ȵ�.

    // for�� ������ ť ����� ���� ���Ϸ����޴µ� �ϴ� ���⼭ �������� while��  ���Ѵٴ� ������ �߾����. 
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;


        int seconds = 0 ;
        int sumWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        
        for (int i = 0; i < truck_weights.length; i++) {
            // 7, 4, 5, 6
            if (bridge.size() < bridge_length) {
                if (sumWeight + truck_weights[i]< weight) {
                    bridge.add(truck_weights[i]);
                    sumWeight += truck_weights[i];
                    seconds++;
                } else {
                    bridge.add(0);
                    seconds++;
                }

            } else {
                int outTruck = bridge.poll();
                if (outTruck != 0) {
                    sumWeight -= outTruck;
                    seconds++;
                }
            }
        }
       
        

        return answer;
    }

    /***************************************************************************/

}

