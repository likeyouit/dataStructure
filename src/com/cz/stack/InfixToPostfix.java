package com.cz.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 */
public class InfixToPostfix {
    static Stack<String> numberStack = new Stack<>();
    static Stack<String> symbolStack = new Stack<>();

    public static void main(String[] args) {
        String expression = "((30+4)*5)-600";

        List<String> list = getListStrings(expression);

        String postExp = transfor(list);

        System.out.println(postExp);



    }

    //把中缀表达式放到list中
    public static List<String> getListStrings(String string){
        List<String> list = new ArrayList<>();
        String[] strings = string.split("");
        for (String str:strings) {
            list.add(str);
        }
        return list;
    }

    public static String transfor(List<String> list){
        int index = 0;
        String mulNumber = "";
        for (String str:list){
            if (str.equals("(")){
                //遇到左括号
                symbolStack.push(str);
            }else if (isSymbol(str)){
                //遇到运算符
                if (symbolStack.isEmpty() || symbolStack.peek().equals("(") || priority(symbolStack.peek()) < priority(str)){
                    symbolStack.push(str);
                }else{
                    numberStack.push(symbolStack.pop());
                    symbolStack.push(str);
                }
            }else if (str.equals(")")){
                //遇到右括号就消除一个左括号
                while(true){
                    String pop = symbolStack.pop();
                    if (pop.equals("(")){
                        break;
                    }
                    numberStack.push(pop);
                }
            }else{
                //遇到数字
                //处理多位数的数字
                mulNumber += str;
                if (index<list.size()-1){
                    if (isSymbol(list.get(index+1)) || "(".equals(list.get(index+1)) || ")".equals(list.get(index+1))){
                        numberStack.push(mulNumber);
                        mulNumber = "";
                    }
                }
                if (index == list.size() - 1){
                    numberStack.push(mulNumber);
                }
            }
            index++;
        }

        //表达式扫描完后，将符号栈最后一个符号压入numberStack
        if (symbolStack.size() == 1){
            numberStack.push(symbolStack.pop());
        }

        //最终的后缀表达式输出
        StringBuilder postfix = new StringBuilder();
        for (String str:
             numberStack) {
            System.out.println("numberStack::"+str);
            postfix.append(" "+str);
        }

        return postfix.toString().substring(1,postfix.length());
    }

    /**
     * 判断str是否为运算符
     * @param str
     * @return
     */
    public static boolean isSymbol(String str){
        return  (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    public static int priority(String str){
        if (str.equals("+") || str.equals("-")){
            return -1;
        }
        if (str.equals("*") || str.equals("/")){
            return '0';
        }
        throw new RuntimeException("都不是...");
    }
}
