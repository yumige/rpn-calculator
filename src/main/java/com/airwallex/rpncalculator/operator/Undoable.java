package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.factory.Storage;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public interface Undoable {
    void undo(Storage storage);
}
