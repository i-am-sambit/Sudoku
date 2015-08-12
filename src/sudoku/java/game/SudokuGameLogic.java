
package sudoku.java.game;

import java.util.Random;

public class SudokuGameLogic 
{
    int[][] arrnumber = {{4, 3, 5, 8, 7, 6, 1, 2, 9}, 
                         {8, 7, 6, 2, 1, 9, 3, 4, 5}, 
                         {2, 1, 9, 4, 3, 5, 7, 8, 6},
                         {5, 2, 3, 6, 4, 7, 8, 9, 1}, 
                         {9, 8, 1, 5, 2, 3, 4, 6, 7}, 
                         {6, 4, 7, 9, 8, 1, 2, 5, 3}, 
                         {7, 5, 4, 1, 6, 8, 9, 3, 2},
                         {3, 9, 2, 7, 5, 4, 6, 1, 8}, 
                         {1, 6, 8, 3, 9, 2, 5, 7, 4}};
    int[][] array;

    int frow = 0,srow = 0,fcol = 0,scol= 0, fgrid,sgrid;
    int[] carry = new int[9];

    Random ran,ranhide,rangrid,rannum;

    public int[][] logic()
    {	
            ran = new Random();
            rangrid = new Random();
            rannum = new Random();

        for (int i = 0; i < 10; i++) 
        {
             for (int j = 0; j < 3; j++) 
             {
            if (j == 0) 
            {
                frow = ran.nextInt(3);
                srow = ran.nextInt(3);
            }
            else if (j == 1) 
            {
                frow = 3 + ran.nextInt(3);
                srow = 3 + ran.nextInt(3);
            } 
            else if (j == 2) 
            {
                frow = 6 + ran.nextInt(3);
                srow = 6 + ran.nextInt(3);
            }

            for (int k = 0; k < 9; k++) {
                carry[k] = arrnumber[frow][k];
                arrnumber[frow][k] = arrnumber[srow][k];
                arrnumber[srow][k] = carry[k];
            }
        }

            //end of row switching        

        //Start switching the column
        for (int j = 0; j < 3; j++) 
        {
            if (j == 0) 
            {
                fcol = ran.nextInt(3);
                scol = ran.nextInt(3);
            } 
            else if (j == 1) 
            {
                fcol = 3 + ran.nextInt(3);
                scol = 3 + ran.nextInt(3);
            } 
            else if (j == 2) 
            {
                fcol = 6 + ran.nextInt(3);
                scol = 6 + ran.nextInt(3);
            }

            for (int k = 0; k < 9; k++) 
            {
                carry[k] = arrnumber[k][fcol];
                arrnumber[k][fcol] = arrnumber[k][scol];
                arrnumber[k][scol] = carry[k];
            }
        }

        fgrid = 1 + rangrid.nextInt(3);
        sgrid = 1 + rangrid.nextInt(3);

        if ((fgrid == 1 && sgrid == 2) || (fgrid == 2 && sgrid == 1)) 
        {
            for (int j = 0; j < 3; j++) 
            {
                for (int k = 0; k < 9; k++) 
                {
                    carry[k] = arrnumber[j][k];
                    arrnumber[j][k] = arrnumber[j + 3][k];
                    arrnumber[j + 3][k] = carry[k];
                }
            }
        } 
        else if ((fgrid == 2 && sgrid == 3) || (fgrid == 3 && sgrid == 2)) 
        {
            for (int j = 3; j < 6; j++) 
            {
                for (int k = 0; k < 9; k++) 
                {
                    carry[k] = arrnumber[j][k];
                    arrnumber[j][k] = arrnumber[j + 3][k];
                    arrnumber[j + 3][k] = carry[k];
                }
            }
        }
        else if ((fgrid == 1 && sgrid == 3) || (fgrid == 3 && sgrid == 1)) 
        {
            for (int j = 0; j < 3; j++) 
            {
                for (int k = 0; k < 9; k++) 
                {
                    carry[k] = arrnumber[j][k];
                    arrnumber[j][k] = arrnumber[j + 6][k];
                    arrnumber[j + 6][k] = carry[k];
                }
            }
        }
        }

        int firstnum, secondnum, shuffle;

    shuffle = 50 + ran.nextInt(6);
    for (int k = 0; k < shuffle; k++) {
        firstnum = 1 + rannum.nextInt(9);
        secondnum = 1 + rannum.nextInt(9);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arrnumber[i][j] == firstnum) {
                    arrnumber[i][j] = secondnum;
                    continue;
                }

                if (arrnumber[i][j] == secondnum) {
                    arrnumber[i][j] = firstnum;
                }
            }
        }
    }

        return arrnumber;
    }

    public int[][] save()
    {
        int savearray[][] = logic();
        return savearray; 
    }
}