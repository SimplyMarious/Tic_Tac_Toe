package com.company;

import static java.lang.Math.abs;

public class StateEvaluator {

    private final String CPU_SYMBOL = "X";
    private final String PLAYER_SYMBOL = "O";
    private final String EMPTY = "";

    public int evaluateState(String[][] state){
        int stateValue = 0;

        //Loop for rows
        for(int row = 0; row < 3; row++){
            int rowValue = 0;
            rowValue = getLineValue(state[row]);
            stateValue += rowValue;
        }

        //Loop for columns
        String[][] transposedState = getTransposedMatrix(state);
        for(int column = 0; column < 3; column++){
            int columnValue = 0;
            columnValue = getLineValue(transposedState[column]);
            stateValue += columnValue;
        }

        //Loop for diagonals
        String[][] diagonalsState = getMatrixDiagonals(state);
        for(int diagonal = 0; diagonal < 2; diagonal++){
            int diagonalValue = 0;
            diagonalValue = getLineValue(diagonalsState[diagonal]);
            stateValue += diagonalValue;
        }

        return stateValue;
    }


    protected int getLineValue(String[] line) {
        int rowSum = getSum(line);
        int filledCells = getFilledCells(line);

        int rowValue = 0;
        switch(filledCells){
            case 0:
                rowValue = 0;
                break;
            case 1:
                rowValue = Integer.signum(rowSum);
                break;
            case 2:
                if(rowSum == 0){
                    rowValue = 0;
                }
                else{
                    rowValue = 10 * Integer.signum(rowSum);
                }
                break;
            case 3:
                if(abs(rowSum) == 1){
                    rowValue = 0;
                }
                else{
                    rowValue = 100 * Integer.signum(rowSum);
                }
                break;
        }
        return rowValue;
    }


    /*
    Returns:
    - value > 0, if the array has more CPU_SYMBOLs
    - value < 0, if the array has more PLAYER_SYMBOLs
    - value = 0, otherwise (empty array or even number of symbols)
    */
    protected int getSum(String[] arrayState){
        int sum = 0;
        for (String symbol : arrayState) {
            if (symbol.equals(CPU_SYMBOL)) {
                sum++;
            } else if (symbol.equals(PLAYER_SYMBOL)) {
                sum--;
            }
        }
        return sum;
    }

    /*
    Returns the filled cells number of an array.
     */
    private int getFilledCells(String[] arrayState) {
        int filledCells = 0;
        for(int index = 0; index < 3; index++){
            if(!arrayState[index].equals(EMPTY)){
                filledCells++;
            }
        }
        return filledCells;
    }

    private static String[][] getTransposedMatrix(String [][] matrix){
        String[][] transposedMatrix = new String[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transposedMatrix[j][i] = matrix[i][j];
        return transposedMatrix;
    }

    private String[][] getMatrixDiagonals(String[][] state) {
        String[][] diagonalsMatrix = new String[2][3];
        for(int index = 0; index < 3; index++){
            diagonalsMatrix[0][index] = state[index][index];
            diagonalsMatrix[1][index] = state[index][2-index];
        }
        return diagonalsMatrix;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
