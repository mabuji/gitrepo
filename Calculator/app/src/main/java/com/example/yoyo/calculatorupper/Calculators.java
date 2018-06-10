package com.example.yoyo.calculatorupper;

import java.util.Stack;


public class Calculators {

    public static String calculate(String equation) {
        Double num1, num2;
        num1 = num2 = 1.0;
        Stack<Double> numStack = new Stack<Double>();
        Stack<Character> charStack = new Stack<Character>();

        if ('s' == equation.charAt(equation.length() - 1)) {
            num1 = Math.sin(Double.parseDouble(equation.substring(0,equation.length()-1))*Math.PI/180);
        }

        else if ('c' == equation.charAt(equation.length() - 1)) {
            num1 = Math.cos(Double.parseDouble(equation.substring(0, equation.length()-1))*Math.PI/180);
        }

        else if ('t' == equation.charAt(equation.length() - 1)) {
            num1 = Math.tan(Double.parseDouble(equation.substring(0, equation.length()-1))*Math.PI/180);
        }
        else {
            for (int i = 1, mark = 0; i < equation.length(); i++) {
                if ('.' == equation.charAt(i)) {
                    continue;
                }
                if ('0' > equation.charAt(i) || '9' < equation.charAt(i)) {
                    numStack.push(Double.parseDouble(equation.substring(0, i)));
                    if (1 == mark) {

                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(num2 * num1);
                        mark = 0;
                    } else if (2 == mark) {

                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(num2 / num1);
                        mark = 0;
                    } else if (3 == mark) {

                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(Math.pow(num2, num1));
                        mark = 0;
                    } else if (4 ==mark) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(num2*Math.sqrt(num1));
                        mark = 0;
                    }

                    if ('*' == equation.charAt(i)) {
                        mark = 1;
                    } else if ('/' == equation.charAt(i)) {
                        mark = 2;
                    } else if ('^' == equation.charAt(i)) {
                        mark = 3;
                    } else if ('√' == equation.charAt(i)){
                        mark = 4;
                    } else if ('=' == equation.charAt(i)) {
                        break;
                    }  else {
                        charStack.push(equation.charAt(i));
                    }
                    equation = equation.substring(i + 1);//将计算过的部分从表达式中剔除
                    i = 0;
                }
            }
            while (!charStack.empty()) {
                if ('+' == charStack.pop()) {

                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num1 + num2);
                } else {

                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 - num1);
                }
            }

            return numStack.pop().toString();
        }
        return num1.toString();
    }


}
