import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    @Test
    public void exhaustiveFindTest1(){
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play , 1, 1);
        int [] actualXY = test.findTailExhaustive();
        int[] expectedXY = {3,1};
        for(int i = 0; i < 2; i++){
            assertEquals(expectedXY[i],actualXY[i]);
        }
        /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and got the correct tail location.
         */
    }

    @Test
    public void exhaustiveFindTest2(){
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play , 3, 1);
        int [] actualXY = test.findTailExhaustive();
        int[] expectedXY = {1,1};
        for(int i = 0; i < 2; i++){
            assertEquals(expectedXY[i],actualXY[i]);
        }
        /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and got the correct tail location. The difference between this test and the
        last one is that I flipped the head to where the tail was and it located the tail correctly. A common error
        occurs when the tail is on top of the head and the method still counts the head as the tail. This test covers
         that case.
         */
    }

    @Test
    public void exhaustiveFindTest3() {
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play, 1, 1);
        int[] actualLength = test.findTailExhaustive();
        int expectedLength = 3;

        assertEquals(expectedLength, actualLength[2]);
     /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and got the correct length of the snake.
         */
    }

    @Test
    public void exhaustiveFindTest4() {
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play, 1, 1);
//        I tested this section by making getExhaustiveChecks public but I changed it back to private
//        int[] actualXYLength = test.findTailExhaustive();
//        int expectedChecks = 11;
//        int actualChecks = test.getExhaustiveChecks();
//
//        assertEquals(expectedChecks, actualChecks);
     /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and calculated the correct amount of checks required.
         */
    }

    @Test
    public void exhaustiveFindTest5(){
        boolean[][] play = {
                {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, true, false, true},
                {true, false, true, false, true},
                {true, true, true, false, true}
        };

        SnakeGame test = new SnakeGame(play , 4, 4);
        int [] actualXYLength = test.findTailExhaustive();
        int[] expectedXYLength = {2,2,17};
        for(int i = 0; i < 3; i++){
            assertEquals(expectedXYLength[i],actualXYLength[i]);
        }
//        I tested this section by making getExhaustiveChecks public but I changed it back to private
//        int actualChecks = test.getExhaustiveChecks();
//        int expectedChecks = 13;
//        assertEquals(expectedChecks,actualChecks);

        /*Considering that a lot of errors can occur when the method checks the borders (because of out bounds
         exceptions), when the snake wraps around it self, or when the tail is above the head, this test covers all
         of those cases. Here I tested the location of the tail, the length of the snake, and the exhaustiveChecks and
         it passed on all of those test.
         */
    }

    @Test
    public void recursiveFindTest1(){
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play , 1, 1);
        int [] actualXY = test.findTailRecursive();
        int[] expectedXY = {3,1};
        for(int i = 0; i < 2; i++){
            assertEquals(expectedXY[i],actualXY[i]);
        }
        /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and got the correct tail location.
         */
    }

    @Test
    public void recursiveFindTest2(){
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play , 3, 1);
        int [] actualXY = test.findTailRecursive();
        int[] expectedXY = {1,1};
        for(int i = 0; i < 2; i++){
            assertEquals(expectedXY[i],actualXY[i]);
        }
         /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and got the correct tail location. The difference between this test and the
        last one is that I flipped the head to where the tail was and it located the tail correctly. A common error
        occurs when the tail is on top of the head and the method still counts the head as the tail. This test covers
         that case.
         */
    }

    @Test
    public void recursiveFindTest3() {
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play, 1, 1);
        int[] actualLength = test.findTailRecursive();
        int expectedLength = 3;

        assertEquals(expectedLength, actualLength[2]);
     /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and got the correct length of the snake.
         */
    }

    @Test
    public void recursiveFindTest4() {
        boolean[][] play = new boolean[5][3];
        play[1][1] = play[2][1] = play[3][1] = true;

        SnakeGame test = new SnakeGame(play, 1, 1);
//        I tested this section by making getRecursiveChecks public but I changed it back to private
//        int[] actualXYLength = test.findTailRecursive();
//        int expectedChecks = 3;
//        int actualChecks = test.getRecursiveChecks();

//        assertEquals(expectedChecks, actualChecks);
     /*This a base case that test the functionality of the method. It gives a basic 5x3 matrix where none of the snake
        is at the border. The test passed and calculated the correct amount of checks required.
         */
    }

    @Test
    public void recursiveFindTest5(){
        boolean[][] play = {
                {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, true, false, true},
                {true, false, true, false, true},
                {true, true, true, false, true}
        };

        SnakeGame test = new SnakeGame(play , 4, 4);
        int [] actualXYLength = test.findTailRecursive();
        int[] expectedXYLength = {2,2,17};
        for(int i = 0; i < 3; i++){
            assertEquals(expectedXYLength[i],actualXYLength[i]);
        }
//        I tested this section by making getRecursiveChecks public but I changed it back to private
//        int actualChecks = test.getRecursiveChecks();
//        int expectedChecks = 17;
//        assertEquals(expectedChecks,actualChecks);

        /*Considering that a lot of errors can occur when the method checks the borders (because of out bounds
         exceptions), when the snake wraps around it self, or when the tail is above the head, this test covers all
         of those cases. Here I tested the location of the tail, the length of the snake, and the exhaustiveChecks and
         it passed on all of those test. I find it interesting that when the snake loops around like this the exhaustive
         check is actually quicker.
         */
    }




}
