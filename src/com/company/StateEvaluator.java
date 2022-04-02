package com.company;

public class StateEvaluator {

    private final String CPU_SYMBOL = "X";
    private final String PLAYER_SYMBOL = "O";
    private final String EMPTY = "";

    public int evaluateState(String[][] state){
        int stateValue = 0;
        for(int row = 0; row < 3; row++){
            int rowValue = 0;

            //TODO: extract method underneath and use it with columns and diagonals

            int rowSum = getSum(state[row]);
            int filledCells = getFilledCells(state[row]);

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
                    if(rowSum == -1 || rowSum == 1){
                        rowValue = 0;
                    }
                    else{
                        rowValue = 100 * Integer.signum(rowSum);
                    }
                break;
            }

            stateValue += rowValue;
        }

        return stateValue;
    }


    /*
    Returns:
    - value > 0, if the array has more CPU_SYMBOLs
    - value < 0, if the array has more PLAYER_SYMBOLs
    - value = 0, otherwise (empty array or even number of symbols)
    */
    private int getSum(String[] arrayState){
        int sum = 0;
        for(int index = 0; index < 3; index++){
            if(arrayState[index].equals(CPU_SYMBOL)){
                sum++;
            }
            else if(arrayState[index].equals(PLAYER_SYMBOL)){
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


    public static void main(String[] args) {
	// write your code here
    }
}
