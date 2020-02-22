public class Test {
    public static void main(String[] arg){
        boolean[][] play = {
                {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, true, false, true},
                {true, false, true, false, true},
                {true, true, true, false, true}
        };

        //line 74

        SnakeGame test = new SnakeGame(play, 4, 4);
        int[] ans = new int[3];
        ans = test.findTailExhaustive();
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        //System.out.print(test.getExhaustiveChecks());
    }
}
