package ongoing.java.ongoing.src;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution(); 
        
        int[] answer1;
        int answer;

        // [2, 1, 3, 2]
        // [1, 1, 9, 1, 1, 1]	

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 1;
        
        answer = sol.solution(priorities, location);

        // for(int id : answer) {
        //     System.out.println("return  id : " + id);
        // }
        System.out.println("return : " + answer);
    }
}
