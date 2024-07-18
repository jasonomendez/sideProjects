

public class Stack<T> extends Node<T> {
    int top;  
    int size; 
    private boolean isDynamic; 
    private T[] stack;

    public Stack(int capacity){
        this.top = 0;  
        this.size = capacity;   
        this.isDynamic = false;
        this.stack = (T[]) new Object[capacity];    
    }     

    public Stack(){
        this.top = 0;  
        this.size = 0;   
        this.isDynamic = true;
        this.stack = (T[]) new Object[10];    
    }

    // Remove the duplicate constructor
    // public Stack(int size){

    // } 

    public void push(T value){ 
        if (top == size){
            if(isDynamic) { 
                System.out.println("Element pushed: " + value); 
                stack[top] = value;
                top++;
            } 
        } else {
            System.out.println("Stack overflow"); 
        }

    } 

    public void pop(){
        if (top < 0) {
            System.out.println("Stack is empty"); 
        } else {
            System.out.println("Element popped: " + stack[top]); 
            top--;
        }

    } 

    public String peek(){ 
        return "element at top is" + stack[top];
    }  

    public void isEmpty(){ 
        if (top < 0) {
            System.out.println("Stack is empty");  
        } else {
            System.out.println("Stack is not empty");
        }

    } 

    public boolean isFull(){ 
        if (top == size){
            System.out.println("Stack is full");  
            return true;
        }else {
            System.out.println("Stack is not full"); 
            return false;
        }

    } 

    @Override 
    public String toString(){
        return "";
    } 

    public static void main(String[] args){
        Stack stack = new Stack(20);  

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  
        stack.isEmpty(); 
        for (int i : array){
            stack.push(i); 
            
        } 
        stack.pop();  
        stack.pop();
        stack.isEmpty();   
        int[] array2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        while(stack.isFull() == false) {
            stack.push(array2);
        }   

        stack.peek(); 




    }

}