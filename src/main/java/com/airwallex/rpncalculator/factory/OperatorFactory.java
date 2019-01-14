package com.airwallex.rpncalculator.factory;

import com.airwallex.rpncalculator.operator.Operable;
import com.airwallex.rpncalculator.operator.Operator;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public class OperatorFactory {
    private static Map<String, Operable> operatorMap = new HashMap<String, Operable>();

    static {
        Set<Class<?>> classes = new HashSet<>();

        Reflections reflections = new Reflections("com.airwallex.rpncalculator.operator");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(com.airwallex.rpncalculator.operator.Operator.class);

        for (Class cls: annotated) {
            Operator op = (Operator) cls.getAnnotation(Operator.class);
            try {
                Operable operable = (Operable) cls.newInstance();
                operatorMap.put(op.name(), operable);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Operable getOperator(String word) {
        Operable op = operatorMap.get(word);
        return op == null ? operatorMap.get("PUSH_NUMBER_8628FBDE-E13A-47F8-BFCC-9799D8334C82") : op;
    }
}

    /** operator map */
