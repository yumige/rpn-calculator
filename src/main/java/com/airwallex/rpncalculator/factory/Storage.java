package com.airwallex.rpncalculator.factory;

import com.airwallex.rpncalculator.calculator.RPNCalculator;
import com.airwallex.rpncalculator.operator.Operable;
import com.airwallex.rpncalculator.operator.Undoable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Stack;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public class Storage {
    private Stack<BigDecimal> workingStack = new Stack<>();
    private Stack<BigDecimal> historyStack = new Stack<>();
    private Stack<Undoable> undoStack = new Stack<>();
    private String currentToken;

    public Storage(){}

    public Stack<BigDecimal> getWorkingStack(){
        return workingStack;
    }

    public Stack<BigDecimal> getHistoryStack(){
        return historyStack;
    }

    public Stack<Undoable> getUndoStack(){
        return undoStack;
    }

    public String getWorkingStackString(){
        Iterator<BigDecimal> it = workingStack.iterator();
        StringBuffer output = new StringBuffer();
        int subNum =0;
        while (it.hasNext()){
            output.append(new BigDecimal(it.next().toString()).setScale(
                    Operable.DISPLAY_PRECISION, RoundingMode.DOWN)
                    .stripTrailingZeros().toPlainString());
            output.append(" ");
            subNum = 1;
        }

        return output.toString().substring(0,output.length()-subNum);
    }


    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }
}
