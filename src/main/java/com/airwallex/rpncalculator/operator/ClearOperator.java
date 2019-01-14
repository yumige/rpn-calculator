package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.factory.Storage;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
@Operator(name = "clear")
public class ClearOperator implements Operable{

    @Override
    public void operate(Storage storage) {
        storage.getWorkingStack().clear();
        storage.getHistoryStack().clear();
        storage.getUndoStack().clear();
    }
}
