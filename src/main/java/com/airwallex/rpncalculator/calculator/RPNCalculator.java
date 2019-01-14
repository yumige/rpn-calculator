package com.airwallex.rpncalculator.calculator;

import com.airwallex.rpncalculator.exception.OperationException;
import com.airwallex.rpncalculator.factory.OperatorFactory;
import com.airwallex.rpncalculator.factory.Storage;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public class RPNCalculator {
    private Storage storage;

    public RPNCalculator() {
        this.storage = new Storage();
    }

    public String process(String input) throws OperationException {
        if(!"".equals(input)){
            int position = -1;
            try{
                for (String word : input.split(" ")) {
                    position = position + word.length() + 1;
                    this.storage.setCurrentToken(word);
                    OperatorFactory.getOperator(word).operate(this.storage);
                }
            }catch (OperationException ex){
                OperationException e = new OperationException(
                        ex.getOperation(), "operator "+ex.getOperation()+" (position: "+position+"): "+ex.getMessage());
                e.setStackInfo(this.storage.getWorkingStackString());
                throw e;

            }
        }

        return this.storage.getWorkingStackString();
    }

}
