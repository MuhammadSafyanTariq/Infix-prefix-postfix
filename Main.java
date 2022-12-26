import java.util.Stack;  
import java. util. *;
import java.lang.Math;
class Expression{
	
	
	int prefixEvaluation(String s){
	Stack<Integer> st=new Stack<>();
	for(int i=s.length()-1;i>=0;i--){
	if(s.charAt(i)>='0' && s. charAt(i)<='9'){
     st.push(s.charAt(i)-'0') ;
		}
    else{
         Integer op1=st.peek();
      st. pop() ;
         Integer op2=st.peek();
st. pop() ;
     switch (s.charAt(i) ){
       case '+':
         st. push(op1+op2);
         break;
case '-':
         st. push(op1-op2);
         break;
 case '*':
         st. push(op1*op2);
         break;
         case '/':
         st. push(op1/op2);
         break;
         case '^':
         st.push((int)Math.pow(op1,op2) ) 
;
         break;
     }

      
    }
	}
	return st.peek();
	}

int precedence (char c) {
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
   //  System. out. println(postfix);
      //st. pop();
      //System. out. 
      //  println(st.peek());
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

void infixToPostfix2(String infix){
String postfix="";
  Stack<Character> st=new Stack<>() ;
  int j=infix.length()-1;
  for(int i=0;i<=j;i++){
    if(Character.isLetter(infix.charAt(i))) {
    postfix=postfix+infix.charAt(i) ;
    }
    else if(true){
      st. push(infix.charAt(i));
    }
  }
  
}





  
}













public class Main {
	public static void main(String[] args) {
		Expression e=new Expression () ;
    System.out.println(e. infixToPostfix("A+(b-c)*d/e-f+g"));
    if(e.precedence('+')==e.precedence('-')){
      System. out. println('1');
    }
	}
}