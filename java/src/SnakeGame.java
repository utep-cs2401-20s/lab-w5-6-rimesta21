public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    SnakeGame() {
        boolean[][] game = new boolean[1][1];
    }

    SnakeGame(boolean[][] G, int headX, int headY) {
        headPosition = new int[2];
        headPosition[0] = headX;
        headPosition[1] = headY;

        game = new boolean[G.length][G[0].length];
        for(int i = 0; i < G.length; i++) {
            for(int j = 0; j < G[i].length; j++) {
                game[i][j] = G[i][j];
            }
        }
    }

    public int[] findTailRecursive(){
        resetCounters();
        int[] currentPosition = {headPosition[0], headPosition[1]};
        int [] previousPosition = {headPosition[0], headPosition[1]};

        return findTailRecursive(currentPosition, previousPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] xyLength = new int[3];
        recursiveChecks++;

        if(currentPosition[0] - 1 > - 1 && currentPosition[0] - 1 != previousPosition[0] &&
                game[currentPosition[0] - 1][currentPosition[1]]){
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            currentPosition[0] = currentPosition[0] - 1;
            return findTailRecursive(currentPosition, previousPosition);

        } else if (currentPosition[0] + 1 < game.length && currentPosition[0] + 1 != previousPosition[0] &&
                game[currentPosition[0] + 1][currentPosition[1]]){
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            currentPosition[0] = currentPosition[0] + 1;
            return findTailRecursive(currentPosition, previousPosition);

        } else if (currentPosition[1] - 1 > -1 && currentPosition[1] - 1 != previousPosition[1] &&
                game[currentPosition[0]][currentPosition[1] - 1]){
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            currentPosition[1] = currentPosition[1] - 1;
            return findTailRecursive(currentPosition, previousPosition);

        } else if (currentPosition[1] + 1 < game[headPosition[0]].length && currentPosition[1] + 1 != previousPosition[1]
                && game[currentPosition[0]][currentPosition[1] + 1]) {
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            currentPosition[1] = currentPosition[1] + 1;
            return findTailRecursive(currentPosition, previousPosition);
        }

        xyLength[0] = currentPosition[0];
        xyLength[1] = currentPosition[1];
        xyLength[2] = recursiveChecks;
        return xyLength;
    }

    public int[] findTailExhaustive() {
        resetCounters();
        int[] xyLength = new int[3];
        int length = 0;
        int neighbors = 0;
        int temp = 0;

        for(int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                temp++;
                if (i == headPosition[0] && j == headPosition[1]) {
                    length++;
                } else if (game[i][j]) {
                    length++;
                    neighbors = NeighborCount(i,j);
                    if (neighbors == 1){
                        xyLength[0] = i;
                        xyLength[1] = j;
                        exhaustiveChecks = temp;
                    }
                }
            }
        }
        xyLength[2] = length;
        return xyLength;
    }

    private int NeighborCount(int row, int col) {
        int count = 0;
        if((row - 1 > -1) && game[row - 1][col]){
            count++;
        }
        if((row + 1 < game.length) && game[row + 1][col]) {
            count++;
        }
        if((col - 1 > -1) && game[row][col - 1]) {
            count++;
        }
        if((col + 1 < game[row].length) && game[row][col + 1]) {
            count++;
        }
        return count;
    }

    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }

    private static int getRecursiveChecks() {
        return recursiveChecks;
    }

}
