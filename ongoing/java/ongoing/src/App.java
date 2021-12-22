package ongoing.java.ongoing.src;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution(); 

        
        int[] answer;

        // int answer;
        // String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        // String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        // answer = sol.solution1(clothes);


        // ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        answer = sol.solution2(genres, plays);

        System.out.println("return : " + answer);
    }
}
