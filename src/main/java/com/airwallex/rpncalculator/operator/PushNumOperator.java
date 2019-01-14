package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.OperationException;
import com.airwallex.rpncalculator.factory.Storage;

import java.math.BigDecimal;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
@Operator(name = "PUSH_NUMBER_8628FBDE-E13A-47F8-BFCC-9799D8334C82")
public class PushNumOperator implements Operable, Undoable {

    @Override
    public void operate(Storage storage) throws OperationException {
        try{
            storage.getWorkingStack().push(new BigDecimal(storage.getCurrentToken()));
        }catch (NumberFormatException e){
            throw new OperationException(storage.getCurrentToken(), "not an operator nor a number!");
        }
        storage.getUndoStack().push(this);
    }

    @Override
    public void undo(Storage storage) {
        storage.getWorkingStack().pop();
    }

}
