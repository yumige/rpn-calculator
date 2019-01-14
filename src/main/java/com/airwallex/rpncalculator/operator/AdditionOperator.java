package com.airwallex.rpncalculator.operator;

import java.math.BigDecimal;
/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
@Operator(name = "+")
public class AdditionOperator extends AbstractDyadicOperator {

    @Override
    public BigDecimal step(BigDecimal numA, BigDecimal numB) {
        return numA.add(numB);
    }

}
