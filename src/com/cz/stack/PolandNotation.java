package com.cz.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器的实现
 */
public class PolandNotation {

    public static void main(String[] args) {
        //计算30 * 5 + 5 - 20
        String reversePolishNotation = "30 5 * 5 + 20 -";

        List<String> list = new ArrayList<>();

        list = getListStrings(reversePolishNotation);

        int result = calculate(list);

        System.out.println("The result is(Polish Notation expression):"+result);

    }

    //把逆波兰表达式做分割放到ArrayList中
    public static List<String> getListStrings(String string){
        List<String> list = new ArrayList<>();
        String[] strings = string.split(" ");
        for (String str:strings) {
            list.add(str);
        }
        return list;
    }
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String str:list){
            if (str.matches("\\d+")){
                stack.push(str);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                if (str.equals("+")){
                    stack.push(num1 + num2+"");
                }else if (str.equals("-")){
                    stack.push(num2 - num1+"");
                }else if (str.equals("*")){
                    stack.push(num2 * num1+"");
                }else if (str.equals("/")){
                    stack.push(num2 / num1+"");
                }else{
                    throw new RuntimeException("error...");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
