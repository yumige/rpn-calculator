package com.airwallex.rpncalculator.operator;

import java.lang.annotation.*;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Operator {
    String name();
}
