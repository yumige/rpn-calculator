package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.OperationException;
import com.airwallex.rpncalculator.factory.Storage;

import java.math.BigDecimal;

/**
 * @Author Sangdi
 * @Date 2019/1/14
 */
public abstract class AbstractUnaryOperator implements Operable,Undoable{

    @Override
    public void operate(Storage storage) throws OperationException {
        if(storage.getWorkingStack().size() < 1){ throw new OperationException(storage.getCurrentToken(), "insufficient parameters"); }
        BigDecimal num = storage.getWorkingStack().pop();
        BigDecimal result;
        try{
            result = step(num);
        }catch (OperationException e){
            storage.getWorkingStack().push(num);
            throw e;
        }
        storage.getWorkingStack().push(result);
        storage.getHistoryStack().push(num);
        storage.getUndoStack().push(this);
    }

    @Override
    public void undo(Storage storage) {
        storage.getWorkingStack().pop();
        storage.getWorkingStack().push(storage.getHistoryStack().pop());
    }

    protected abstract BigDecimal step (BigDecimal num) throws OperationException;
}
