package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.OperationException;

import java.math.BigDecimal;

/**
 * @Author Sangdi
 * @Date 2019/1/14
 */
@Operator(name = "sqrt")
public class SqrtOperator extends AbstractUnaryOperator {

    @Override
    protected BigDecimal step(BigDecimal num) throws OperationException {
        if(num.signum() == -1){
            throw new OperationException(this.getClass().getAnnotation(Operator.class).name(), "cannot sqrt a negative value");
        }
        return this.sqrt(num);
    }

    // sqrt with double value will lose precision
    // this method can be replaced with BigDecimal.sqrt if using JAVA 9
    private BigDecimal sqrt(BigDecimal num){
        return new BigDecimal(Math.sqrt(num.doubleValue()));
    }
}
