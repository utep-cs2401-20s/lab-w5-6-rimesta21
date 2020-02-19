public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    SnakeGame() {
        boolean[][] game = new boolean[1][1];
    }

    SnakeGame(boolean[][] G, int x, int y) {
        headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;

        game = new boolean[G.length][G[0].length];
        for(int i = 0; i < G.length; i++) {
            for(int j = 0; j < G[i].length; j++) {
                game[i][j] = G[i][j];
            }
        }
    }

    public int[] findTailExhaustive() {
        System.out.println(headPosition[0] +" "+ headPosition[1]);
        int[] xyLength = new int[3];
        int length = 0;
        exhaustiveChecks = 0;
        /* Am I part of the snake?
           Everytime you find a true you count
         */
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                if(game[i][j]) {
                    length++;

                    if(i == 0 && j == 0){
                        if((game[0][1] || game[1][0]) && (i != headPosition[0] && j != headPosition[1]) ){
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(i == game.length-1 && j == game[i].length-1){
                        if((game[game.length][game[i].length - 2] || game[game.length - 2][game[i].length])
                                && (i != headPosition[0] && j != headPosition[1])){
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(i == 0 && j == game[i].length-1){
                        if((game[0][game[i].length - 2] || game[1][game[i].length])
                                && (i != headPosition[0] && j != headPosition[1])){
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(i == game.length-1 && j == 0){
                        if((game[game.length - 1][1] || game[game.length - 2][0])
                                && (i != headPosition[0] && j != headPosition[1])){
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(i-1 < 0) {
                        if ((game[i][j + 1] && !game[i][j - 1] || !game[i][j + 1] && game[i][j - 1])
                                && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        } else if ((game[i + 1][j]) && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(j-1 < 0) {
                        if ((game[i][j + 1]) && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        } else if ((!game[i - 1][j] && game[i + 1][j] || game[i - 1][j] && !game[i + 1][j])
                                && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(j+1 == game[i].length) {
                        System.out.println("test");
                        if ((game[i][j - 1]) && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        } else if ((!game[i - 1][j] && game[i + 1][j] || game[i - 1][j] && !game[i + 1][j])
                                && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if(i+1 == game.length) {
                        if ((game[i][j + 1] && !game[i][j - 1] || !game[i][j + 1] && game[i][j - 1])
                                && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        } else if ((game[i -1][j]) && (i != headPosition[0] && j != headPosition[1])) {
                            xyLength[0] = i;
                            xyLength[1] = j;
                        }
                    } else if (((game[i][j + 1] && !game[i][j - 1]) || (!game[i][j + 1] && game[i][j - 1]))
                            && (i != headPosition[0] && j != headPosition[1])) {
                        System.out.println(i + " " + j);
                        xyLength[0] = i;
                        xyLength[1] = j;
                    } else if ((!game[i - 1][j] && game[i + 1][j] || game[i - 1][j] && !game[i + 1][j])
                            && (i != headPosition[0] && j != headPosition[1])) {
                        xyLength[0] = i;
                        xyLength[1] = j;
                    }
                }
            }
        }
        xyLength[2] = length;
        return xyLength;
    }

}
