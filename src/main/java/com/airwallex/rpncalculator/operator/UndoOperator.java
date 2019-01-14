package com.airwallex.rpncalculator.operator;


import com.airwallex.rpncalculator.factory.Storage;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
@Operator(name = "undo")
public class UndoOperator implements Operable {

    @Override
    public void operate(Storage storage) {
        Undoable operator = storage.getUndoStack().pop();
        operator.undo(storage);
    }
}
