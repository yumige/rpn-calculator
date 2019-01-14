package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.OperationException;
import com.airwallex.rpncalculator.factory.Storage;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public interface Operable {
    int PRECISION = 15;
    int DISPLAY_PRECISION = 10;

    void operate(Storage storage) throws OperationException;
}
