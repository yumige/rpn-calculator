package com.airwallex.rpncalculator;

import com.airwallex.rpncalculator.calculator.RPNCalculator;
import com.airwallex.rpncalculator.exception.OperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public class Application {

    public static void main(String args[]){

        RPNCalculator calculator = new RPNCalculator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("calculator started.");

        while (true){
            try {
                //load input
                String input = reader.readLine();
                String output = calculator.process(input);
                System.out.println(output);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (OperationException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getStackInfo());
            }
        }
    }
}
