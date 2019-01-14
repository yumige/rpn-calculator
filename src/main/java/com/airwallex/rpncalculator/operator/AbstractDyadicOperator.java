package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.OperationException;
import com.airwallex.rpncalculator.factory.Storage;

import java.math.BigDecimal;

/**
 * @Author Sangdi
 * @Date 2019/1/14
 */
public abstract class AbstractDyadicOperator implements Operable,Undoable{
    @Override
    public void operate(Storage storage) throws OperationException {
        if(storage.getWorkingStack().size() < 2){ throw new OperationException(storage.getCurrentToken(), "insufficient parameters"); }
        BigDecimal numA = storage.getWorkingStack().pop();
        BigDecimal numB = storage.getWorkingStack().pop();
        BigDecimal result;
        try{
            result = step(numA,numB);
        }catch (OperationException e){
            storage.getWorkingStack().push(numB);
            storage.getWorkingStack().push(numA);
            throw e;
        }


        storage.getWorkingStack().push(result);
        storage.getHistoryStack().push(numA);
        storage.getHistoryStack().push(numB);
        storage.getUndoStack().push(this);
    }

    public abstract BigDecimal step(BigDecimal numA,BigDecimal numB) throws OperationException;

    @Override
    public void undo(Storage storage) {
        storage.getWorkingStack().pop();
        storage.getWorkingStack().push(storage.getHistoryStack().pop());
        storage.getWorkingStack().push(storage.getHistoryStack().pop());
    }
}
