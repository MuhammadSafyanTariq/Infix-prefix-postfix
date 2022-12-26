import java.util.Stack;  
import java. util. *;
import java.lang.Math;
class Expression{
	


static int precedence (char c) {
if(c=='^'){
  return 3;
}
else if(c=='*'|| c=='/'){
  return 2;
}
 else if(c=='+'||c=='-'){
  return 1;
}
else{
  return 0;
}
}

String infixToPostfix(String infix){

String postfix="";
  Stack<Character> st=new Stack<>() ;
  int j=infix.length()-1;;
  for(int i=0;i<=j;i++){
    if(Character.isLetter(infix.charAt(i))) {
    postfix=postfix+infix.charAt(i) ;
    }
      else if(st.isEmpty()){
      st. push(infix.charAt(i));
    }
    else if(infix.charAt(i)=='('){
      st. push(infix.charAt(i));
    }

    else if(infix.charAt(i)==')'){
      while(st.peek()!='('){
        postfix=postfix+st.peek() ;
        st. pop();
      }
      st. pop() ;

    }
      

else if(precedence (infix.charAt(i))> precedence(st.peek())){
      st. push(infix.charAt(i));
    }

else if((precedence (infix.charAt(i))< precedence(st.peek()))){
  postfix=postfix+st.peek() ;
    st. pop() ;
  while((precedence (infix.charAt(i))< precedence(st.peek()))&&st.indexOf(st.peek())>=1){
postfix=postfix+st.peek() ;
    st. pop() ;
} 
      st. push(infix.charAt(i)) ;
    }
else if((precedence (infix.charAt(i))== precedence(st.peek()))&&st.indexOf(st.peek())>=1){
  postfix=postfix+st.peek() ;
    st. pop() ;
while((precedence (infix.charAt(i))< precedence(st.peek()))){
postfix=postfix+st.peek() ;
    st. pop() ;
} 
      st. push(infix.charAt(i)) ;
}

    
  }
while(st.indexOf(st.peek())!=0){
  postfix=postfix+st.peek() ;
st. pop() ;
        }
  
  postfix=postfix+st.peek() ;
return postfix;


}

String postfixToInfix(String postfix){
String infix="";
  Stack<String> st=new Stack<>() ;
  int j=postfix.length()-1;
  for(int i=0;i<=j;i++){
    char ch = postfix.charAt(i);
    if(Character.isLetter(postfix.charAt(i))) {
    st. push(ch+"");
    }
    else {
  String oprn1=st.pop() ;
      
    String oprn2=st.pop() ;      st. push("("+oprn2+ ""+ch+""+ oprn1+")") ;
      
    }
  }
  return st. pop();
}


/*
        
static String infixToPrefix(String infix)
{

    // stack for operators.

    Stack<Character> operators = new Stack<Character>();
 

    // stack for operands.

    Stack<String> operands = new Stack<String>();
 

    for (int i = 0; i < infix.length(); i++) 

    {
 

        // If current character is an

        // opening bracket, then

        // push into the operators stack.

        if (infix.charAt(i) == '(') 

        {

            operators.push(infix.charAt(i));

        }
 

        // If current character is a

        // closing bracket, then pop from

        // both stacks and push result

        // in operands stack until

        // matching opening bracket is

        // not found.

        else if (infix.charAt(i) == ')') 

        {

            while (!operators.empty() && 

                operators.peek() != '(') 

                {
 

                // operand 1

                String op1 = operands.peek();

                operands.pop();
 

                // operand 2

                String op2 = operands.peek();

                operands.pop();
 

                // operator

                char op = operators.peek();

                operators.pop();
 

                // Add operands and operator

                // in form operator +

                // operand1 + operand2.

                Stri*/





static boolean isOperator(char c)
{

    return (!(c >= 'a' && c <= 'z') && 

            !(c >= '0' && c <= '9') && 

            !(c >= 'A' && c <= 'Z'));
}
 
// Function to find priority 
// of given operator.

static int getPriority(char C)
{

    if (C == '-' || C == '+')

        return 1;

    else if (C == '*' || C == '/')

        return 2;

    else if (C == '^')

        return 3;

    return 0;
}
 
// Function that converts infix
// expression to .

static String infixToPrefix(String infix)
{

    // stack for operators.

    Stack<Character> operators = new Stack<Character>();
 

    // stack for operands.

    Stack<String> operands = new Stack<String>();
 

    for (int i = 0; i < infix.length(); i++) 

    {
 

        // If current character is an

        // opening bracket, then

        // push into the operators stack.

        if (infix.charAt(i) == '(') 

        {

            operators.push(infix.charAt(i));

        }
 

        // If current character is a

        // closing bracket, then pop from

        // both stacks and push result

        // in operands stack until

        // matching opening bracket is

        // not found.

        else if (infix.charAt(i) == ')') 

        {

            while (!operators.empty() && 

                operators.peek() != '(') 

                {
 

                // operand 1

                String op1 = operands.peek();

                operands.pop();
 

                // operand 2

                String op2 = operands.peek();

                operands.pop();
 

                // operator

                char op = operators.peek();

                operators.pop();
 

                // Add operands and operator

                // in form operator +

                // operand1 + operand2.

                String tmp = op + op2 + op1;

                operands.push(tmp);

            }
 

            // Pop opening bracket 

            // from stack.

            operators.pop();

        }
 

        // If current character is an

        // operand then push it into

        // operands stack.

        else if (!isOperator(infix.charAt(i))) 

        {

            operands.push(infix.charAt(i) + "");

        }
 

        // If current character is an

        // operator, then push it into

        // operators stack after popping

        // high priority operators from

        // operators stack and pushing

        // result in operands stack.

        else

        {

            while (!operators.empty() && 

                getPriority(infix.charAt(i)) <= 

                    getPriority(operators.peek())) 

                {
 

                String op1 = operands.peek();

                operands.pop();
 

                String op2 = operands.peek();

                operands.pop();
 

                char op = operators.peek();

                operators.pop();
 

                String tmp = op + op2 + op1;

                operands.push(tmp);

            }
 

            operators.push(infix.charAt(i));

        }

    }
 

    // Pop operators from operators 

    // stack until it is empty and 

    // operation in add result of 

    // each pop operands stack.

    while (!operators.empty()) 

    {

        String op1 = operands.peek();

        operands.pop();
 

        String op2 = operands.peek();

        operands.pop();
 

        char op = operators.peek();

        operators.pop();
 

        String tmp = op + op2 + op1;

        operands.push(tmp);

    }
 

    // Final prefix expression is

    // present in operands stack.

    return operands.peek();
}
  static StringBuilder infixToPreFix(String expression){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor "("
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

    public static void main(String[] args) {
        String exp = "A+B*(C^D-E)";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPreFix(exp));
    }
    }


public class Main {
	public static void main(String[] args) {
		Expression e=new Expression () ;
    System.out.println(e. infixToPostfix("A+b-c*d/e-f+g"));
  System.out.println ( e. postfixToInfix("Abcd*e/f-g+"));
    System.out.println ( e. infixToPreFix("A+b-c*d/e-f+g"));
	}
}