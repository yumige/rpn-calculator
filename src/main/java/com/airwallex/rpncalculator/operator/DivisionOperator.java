package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.OperationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
@Operator(name = "/")
public class DivisionOperator extends AbstractDyadicOperator {

    @Override
    public BigDecimal step(BigDecimal numA, BigDecimal numB) throws OperationException {
        if(numA.compareTo(BigDecimal.ZERO) == 0){
            throw new OperationException(this.getClass().getAnnotation(Operator.class).name(), "cannot divide zero value");
        }
        return numB.divide(numA, Operable.PRECISION, RoundingMode.HALF_UP);
    }

}
