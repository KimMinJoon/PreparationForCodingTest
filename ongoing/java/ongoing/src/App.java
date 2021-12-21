package ongoing.java.ongoing.src;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution(); 

        int answer;
        // String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        answer = sol.solution1(clothes);

        System.out.println("return : " + answer);
    }
}
