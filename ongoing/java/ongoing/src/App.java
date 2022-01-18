package ongoing.java.ongoing.src;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution(); 
        
        int[] answer1;
        int answer;

        // 2	10	[7,4,5,6]	8

        // 100	100	[10]	101

        // 100	100	[10,10,10,10,10,10,10,10,10,10]	110



        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        
        answer = sol.solution(bridge_length, weight, truck_weights);

        // for(int id : answer) {
        //     System.out.println("return  id : " + id);
        // }
        System.out.println("return : " + answer);
    }
}
