import java.util.Scanner; //will use scanner later

class Stack {
	int Stack[];
	int StackSize;
	int StackPosition;
	
	Stack(int size) { //constructor here
		if(size > 0) {
			Stack = new int[size];
			StackSize = size;
			StackPosition = -1; //stack is empty
		} else System.out.println("Stack has to be positive.");
	}
	
	void push(int num) {
		if(StackPosition == -1) { //if stack is empty, simply add the num on top
			Stack[++StackPosition] = num;
			return;
		}
		if(num <= Stack[StackPosition]) { //if the number below in the stack is smaller than num, add
			Stack[StackPosition] += num;
			return;
		}
		if(StackPosition >= StackSize - 1) { //if stack is full, leave message
			System.out.println("Stack is full."); 
			return;
		}
		Stack[++StackPosition] = num; //if none of the previous ifs are true, just put num on top
	}
	
	boolean isStackEmpty() { //a method of checking if stack is empty
		if(StackPosition <= -1) //check if stack is empty
			return true;
		else
			return false;
	}
	
	boolean isStackFull() { //this is another method of checking if stack is full
		if(StackPosition >= StackSize - 1) //check if stack is full
			return true;
		else
			return false;
	}

	int pop() {
		if(StackPosition <= -1) { //check if stack is empty again
			System.out.println("Stack is empty.");
			return -1; //return -1 b/c this needs to return an integer
		} else { //otherwise, take out number at top of stack
			int ret;
			ret = Stack[StackPosition--];
			return ret;
		}
	}
	
	void PrintStack() {
		for(int i = StackPosition; i >= 0; i--) //print out the integers in stack
			System.out.println("Stack[" + i + "] = " + Stack[i]);
	}
}

class ExecuteStack { //new class for demonstrating how to use Stack
	public static void main(String args[])
	throws java.io.IOException {
		Stack myStack = new Stack(25);
		Scanner sc = new Scanner(System.in); //create scanner object
		char ch;
		
	mainloop:
		while(true) { //print menu
			System.out.println("1 - Push an integer");
			System.out.println("2 - Pop an integer");
			System.out.println("3 - Print stack");
			System.out.println("4 - Quit the program");
			System.out.print("Select one: ");
			ch = (char) System.in.read();
			while (ch < '1' || ch > '4')
				ch = (char) System.in.read();
			
			switch(ch) {
			case '1':
				System.out.println("Enter the integer you want to push:");
				int num = sc.nextInt(); //use scanner to get an integer
				myStack.push(num);
				break;
			case '2':
				if(!myStack.isStackEmpty())
					System.out.println("Popped: " + myStack.pop());
				else
					System.out.println("Stack is empty.");
				break;
			case '3':
				myStack.PrintStack();
				break;
			case '4':
				break mainloop;
			}
		}
	}
}
