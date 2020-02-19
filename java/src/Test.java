public class Test {
    public static void main(String[] arg){
        boolean[][] play = {
                {false, false, false, false},
                {false, true, true, true},
                {false, false, false, false},
                {false, false, false, false}
        };

        SnakeGame test = new SnakeGame(play, 1, 1);
        int[] ans = new int[3];
        ans = test.findTailExhaustive();
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
