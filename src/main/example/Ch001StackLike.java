package example;

import java.util.Stack;

class Ch001StackLike {
    public static void main(String[] args) {
            System.out.println("\n\n ------ start ------");
            Stack<Pair> pairs = new Stack<>();
            MyStck myStck = new MyStck(new Stack<>());
            myStck.push(1);
            myStck.push(2);
            myStck.push(3);
            System.out.println("min is " + myStck.getMin()); // should print 1

            // next
            myStck.pop();
            myStck.push(0);
            myStck.push(4);
            System.out.println("min is " + myStck.getMin()); // should print 0
            // next
            myStck.pop();
            myStck.pop();
            myStck.push(5);
            System.out.println("min is " + myStck.getMin()); // should print 1
    }
}

record Pair(int a, int b){}
record MyStck(Stack<Pair> stck){
    public int pop() { return  stck.pop().a();}
    public void push(int in) {
        if (stck.size() == 0) {
            stck.push(new Pair(in, in));
            return;
        }
        if (stck.size() != 0) {
            if (in <= stck.peek().b()) stck.push(new Pair(in, in));
            else stck.push(new Pair (in, stck.peek().b()));
        }
    }
    public int getMin(){
        return stck.peek().b();
    }
    public void print(){
        Stack<Pair> clnd = (Stack<Pair>) stck.clone();

        while (! clnd.empty()) {
            Pair pop = clnd.pop();
            System.out.println(clnd.size() + " : " + pop.a() + " % " + pop.b());
        }
    }
}