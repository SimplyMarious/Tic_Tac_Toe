package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateEvaluatorTest {

    private StateEvaluator stateEvaluator;

    @BeforeEach
    void setUp() {
        stateEvaluator = new StateEvaluator();
    }


    /*
    ******************
    getSum() test
    ******************
    */
    @Test
    void testGetSumWithEmptyLine(){
        String[] state = {"","",""};
        assertEquals(0, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithOneCPUSymbolLine(){
        String[] state = {"X","",""};
        assertEquals(1, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithTwoCPUSymbolLine(){
        String[] state = {"X","X",""};
        assertEquals(2, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithThreeCPUSymbolLine(){
        String[] state = {"X","X","X"};
        assertEquals(3, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithOnePlayerSymbolLine(){
        String[] state = {"O","",""};
        assertEquals(-1, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithTwoPlayerSymbolLine(){
        String[] state = {"O","O",""};
        assertEquals(-2, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithThreePlayerSymbolLine(){
        String[] state = {"O","O","O"};
        assertEquals(-3, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithOnePlayerSymbolAndOneCPUSymbolLine(){
        String[] state = {"O","X",""};
        assertEquals(0, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithTwoPlayerSymbolAndOneCPUSymbolLine(){
        String[] state = {"O","O","X"};
        assertEquals(-1, stateEvaluator.getSum(state));
    }

    @Test
    void testGetSumWithOnePlayerSymbolAndTwoCPUSymbolLine(){
        String[] state = {"O","X","X"};
        assertEquals(1, stateEvaluator.getSum(state));
    }

    /*
    ******************
    getLineValue() test
    ******************
     */

    @Test
    void testGetLineValueWithEmptyLine(){
        String[] state = {"","",""};
        assertEquals(0, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithOneCPUSymbolLine(){
        String[] state = {"X","",""};
        assertEquals(1, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetGetLineValueTwoCPUSymbolLine(){
        String[] state = {"X","X",""};
        assertEquals(10, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithThreeCPUSymbolLine(){
        String[] state = {"X","X","X"};
        assertEquals(100, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithOnePlayerSymbolLine(){
        String[] state = {"O","",""};
        assertEquals(-1, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithTwoPlayerSymbolLine(){
        String[] state = {"O","O",""};
        assertEquals(-10, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithThreePlayerSymbolLine(){
        String[] state = {"O","O","O"};
        assertEquals(-100, stateEvaluator.getLineValue(state));
    }


    @Test
    void testGetLineValueWithOnePlayerSymbolAndOneCPUSymbolLine(){
        String[] state = {"O","X",""};
        assertEquals(0, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithTwoPlayerSymbolAndOneCPUSymbolLine(){
        String[] state = {"O","O","X"};
        assertEquals(0, stateEvaluator.getLineValue(state));
    }

    @Test
    void testGetLineValueWithOnePlayerSymbolAndTwoCPUSymbolLine(){
        String[] state = {"O","X","X"};
        assertEquals(0, stateEvaluator.getLineValue(state));
    }


    /*
    ******************
    evaluateState() test
    ******************
     */

    @Test
    void testEvaluateStateWithCPUSymbolInTheCenter(){
        String[][] state = {{"","",""}, {"","X",""}, {"","",""}};
        assertEquals(4, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithPlayerSymbolInTheCenter(){
        String[][] state = {{"","",""}, {"","O",""}, {"","",""}};
        assertEquals(-4, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithThreeHorizontalCPUSymbolsAndSomePlayerSymbols(){
        String[][] state = {{"X","X","X"}, {"O","O",""}, {"","",""}};
        assertEquals(91, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithThreeHorizontalPlayersSymbolsAndSomeCPUSymbols(){
        String[][] state = {{"O","O","O"},
                            {"X","X",""},
                            {"","",""}};
        assertEquals(-91, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithThreeVerticalCPUSymbolsAndSomePlayerSymbols(){
        String[][] state = {{"","X",""},
                            {"O","X",""},
                            {"","X","O"}};
        assertEquals(100, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithThreeVerticalPlayersSymbolsAndSomeCPUSymbols(){
        String[][] state = {{"","O",""},
                            {"X","O",""},
                            {"","O","X"}};
        assertEquals(-100, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithThreeDiagonalCPUSymbolsAndSomePlayerSymbols(){
        String[][] state = {{"X","","O"},
                            {"O","X",""},
                            {"","","X"}};
        assertEquals(102, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithThreeDiagonalPlayersSymbolsAndSomeCPUSymbols(){
        String[][] state = {{"O","","X"},
                            {"X","O",""},
                            {"","","O"}};
        assertEquals(-102, stateEvaluator.evaluateState(state));
    }

    @Test
    void testEvaluateStateWithFullMatrixAsDraw(){
        String[][] state = {{"X","X","O"},
                            {"O","O","X"},
                            {"X","X","O"}};
        assertEquals(0, stateEvaluator.evaluateState(state));
    }


















}