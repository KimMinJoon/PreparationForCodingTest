package ongoing.java.ongoing.src;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution(); 
        
        int[] answer;


        // [93, 30, 55]	[1, 30, 5]	[2, 1]
        // [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        
        answer = sol.solution(progresses, speeds);

        for(int id : answer) {
            System.out.println("return  id : " + id);
        }
        // System.out.println("return : " + answer);
    }
}
