import java.util.Scanner;
import java.util.Stack;
class Expression {
//This is the method to check the precedence of the operators
static int precedence(char c) {
if (c == '^') {
return 3;
} else if (c == '*' || c == '/') {
return 2;
} else if (c == '+' || c == '-') {
return 1;
} else {
return 0;
}
}
//This is the method to convert infix to postfix
String infixToPostfix(String infix) {Stack<Character> operators = new Stack<>();

char symbol;

String postfix = "";

for (int i = 0; i < infix.length(); ++i) {

symbol = infix.charAt(i);

if (Character.isLetter(symbol))

postfix = postfix + symbol;

else if (symbol == '(') {

operators.push(symbol);

} else if (symbol == ')') {

while (operators.peek() != '(') {

postfix = postfix + operators.pop();

}

operators.pop();

} else {

while (!operators.isEmpty() && !(operators.peek() == '(')

&& precedence(symbol) <= precedence(operators.peek()))

postfix = postfix + operators.pop();

operators.push(symbol);

}

}

while (!operators.isEmpty())

postfix = postfix + operators.pop();

return postfix;

}

//This is the method to convert the postfix to infix

String postfixToInfix(String postfix) {

Stack<String> st = new Stack<>();
   int j = postfix.length() - 1;

for (int i = 0; i <= j; i++) {

char ch = postfix.charAt(i);

if (Character.isLetter(postfix.charAt(i))) {

st.push(ch + "");

} else {

String oprn1 = st.pop();

String oprn2 = st.pop();

st.push("(" + oprn2 + "" + ch + "" + oprn1 + ")");

}

}

return st.pop();

}

//This is the method to convert infix to prefix

String infixToPrefix(String infix) {

String prefix = "";

String reverseString = "";

for (int i = infix.length() - 1; i >= 0; i--) {

reverseString = reverseString + infix.charAt(i);

}

String reversePostfix = infixToPostfix(reverseString);

for (int i = reversePostfix.length() - 1; i >= 0; i--) {

prefix = prefix + reversePostfix.charAt(i);

}

return prefix;

}
  //This is the method to convert prefix to infix
String prefixToInfix(String prefix) {
String infix = "";
String reverseString = "";
for (int i = prefix.length() - 1; i >= 0; i--) {
reverseString = reverseString + prefix.charAt(i);
}
String reversePostfix = postfixToInfix(reverseString);
for (int i = reversePostfix.length() - 1; i >= 0; i--) {
char c = reversePostfix.charAt(i);
if (c == '(') {
c = ')';
} else if (c == ')') {
c = '(';
}
infix = infix + c;
}
return infix;
}
//This is the main method where I called all the Methods
public static void main(String[] args) {
Expression e = new Expression();
int i = 1;
int ch;
while (i == 1) {
System.out.println("********WELCOME********");
  Scanner scan = new Scanner(System.in);
String expression;
System.out.println("Enter the Expression: ");
expression = scan.nextLine();
System.out.println("Which operation do you want to perform: ");
System.out.println("1_Infix to Postfix. ");
System.out.println("2_Postfix to Infix. ");
System.out.println("3_Infix to Prefix. ");
System.out.println("4_Prefix to Infix. ");
ch = scan.nextInt();
System.out.println();
switch (ch) {
case 1:
System.out.println("***Postfix***: " + e.infixToPostfix(expression));
break;
case 2:
System.out.println("***infix***: " + e.postfixToInfix(expression));
break;
case 3:
System.out.println("***prefix***: " + e.infixToPrefix(expression));
break;
case 4:
System.out.println("***Infix***: " + e.prefixToInfix(expression));
break;
}
System.out.println();
System.out.println("******Thanks******");
System.out.println("Do you want to continue? Press 1");
  i = scan.nextInt();
}
}
}