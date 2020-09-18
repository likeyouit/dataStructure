package com.cz.stack;

/**
 * @author
 * 简单的计算器实现,有bug
 */
public class CaculateStack {
    public static void main(String[] args) {
        String expression = "5-2*3+1";
        ArrStack2 numberStack = new ArrStack2(10);
        ArrStack2 symbolStack = new ArrStack2(10);
        String tempMulNumber = "";

        int index = 0; //expression的索引
        int num1 = 0;  //栈弹出的数据
        int num2 = 0;  //栈弹出的数据
        int symbol = ' ';
        while(true){

            char ch = expression.substring(index, index + 1).charAt(0);
            //如果是符号
            if (symbolStack.isSymbol(ch)){
                //符号栈有符号
                if (!symbolStack.isEmpty()){
                    //比较优先级
                    if (symbolStack.priority(ch) < symbolStack.priority(symbolStack.peek())){
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        symbol = symbolStack.pop();
                        int result = numberStack.cal(num1, num2, symbol);
                        numberStack.push(result);
                        symbolStack.push(ch);
                    }else{
                        symbolStack.push(ch);
                    }
                }else {
                    //符号栈没有符号
                    symbolStack.push(ch);
                }
            }else{
                //如果不是符号
//                numberStack.push(ch-48);
                //考虑多位数
                tempMulNumber +=ch;
                if (index == expression.length() - 1){
                    numberStack.push(Integer.parseInt(tempMulNumber));
                }else {
                    char tempCh = expression.substring(index+1,index+2).charAt(0);
                    if(symbolStack.isSymbol(tempCh)){
                        numberStack.push(Integer.parseInt(tempMulNumber));
                        tempMulNumber="";
                    }
                }

            }
            index++;
            if (index == expression.length()){
                break;
            }
        }

        //表达式扫描完后，还有运算符的情况下继续计算
        while (true) {
            if (symbolStack.isEmpty()){
                System.out.println("The result is:"+numberStack.pop());
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            symbol = symbolStack.pop();
            int result = numberStack.cal(num1,num2,symbol);
            numberStack.push(result);
        }
    }
}

class Demo{

}
/**
 * copy from ArrStack and update some functions
 */
class ArrStack2{
    int top = -1;  //索引值
    int[] stack;  //存放数据
    int maxSize;  //栈容量

    public ArrStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == this.maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满...");
            return;
        }
        stack[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空..");
        }
        return stack[top--];
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈空...");
        }
        return  stack[top];
    }

    public void showArrStack(){
        for (int i = top; i >= 0 ; i--) {
            System.out.println("stack::"+stack[i]);
        }
    }

    /**
     * 判断当前运算符的优先级,优先级越高，数字越大
     * @param calcuSymbol 运算符
     * @return
     */
    public int priority(int calcuSymbol){
        if (calcuSymbol == '*' || calcuSymbol == '/'){
            return 1;
        }else if (calcuSymbol == '+' || calcuSymbol == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断字符是否为字符
     * @param symbol 字符
     */
    public boolean isSymbol(char symbol){
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

    /**
     * 执行运算
     * @param num1 数栈栈顶数据
     * @param num2 数栈次栈顶数据
     * @param symbol 符号栈栈顶数据
     * @return 计算结果
     */
    public int cal(int num1,int num2,int symbol){
        switch (symbol){
            case '+':return num1 + num2;
            case '-':return num2 - num1;
            case '*':return num1 * num2;
            case '/':return num2 / num1;
            default:break;
        }
        return ' ';
    }
}