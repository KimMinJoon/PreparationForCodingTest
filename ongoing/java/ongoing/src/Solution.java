package ongoing.java.ongoing.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
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

    // 음 다리를 큐라고 생각하고 조건에 안맞을때 0을 넣고 초를 늘리는 생각까지는 좋았다.
    // 근데 다리에 진입하고자하는 트럭배열을 포문으로 반복해서 도는게 맞긴했는데 
    // 초를 셀 때, while로 감싸서 큐에서 밀어내기를 해야한다는 생각을 하지 못함.
    // 왤까?
    // 반복문을 안쓰려고했던것같음. 
    // 왜? 시도를 중지하지 않았으면 좋았을것. 사고방식을 폐쇄하면 안좋고 열자 해보고 2중 3중 4중까지 사고를 열어는 놔야할듯
    // 그리고 수행시간 초과되면 그때가서 개선하는게 맞다봄.
    // 너무 한꺼번에 끝내려고 하다가 고립된듯.

    // for문 내에서 큐 사이즈를 빼고 더하려고햇는데 일단 여기서 막혔으면 while로  감싼다는 생각을 했어야함. 
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;


        int seconds = 0 ;
        int sumWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        

        // 트럭 IN  / 트럭 OUT / 트럭 MOVE 이 3가지가 동시에 1초에 진행되어야함.  
        // 트럭 1개가 무게가 많이 나가서 다리를 오랫동안 점유할 경우 카운팅이 여러번 되어야하기때문에 while문 활용
        
        while(1) {

            for (int i = 0; i < truck_weights.length; i++) {
                // 7, 4, 5, 6
    
                // 다리 입장 가능 차량 수 확인조건
                if (bridge.size() < bridge_length) {
    
                    // 다리 입장 가능 총 중량 확인 조건
                    if (sumWeight + truck_weights[i]< weight) {
    
                        bridge.add(truck_weights[i]);
    
                        sumWeight += truck_weights[i];
                        seconds++;
                    } else {
                        bridge.add(0);      // 중량 초과로 0인 무게의 트럭을 큐에 추가.???
                    }
    
                } else {
                    int outTruck = bridge.poll();
                    if (outTruck != 0) {
                        sumWeight -= outTruck;
                        seconds++;
                    }
                }
            }

        }
        
        
       
        
        

        return answer;
    }

    /***************************************************************************/

}

