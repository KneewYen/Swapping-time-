import java.util.Scanner;
public class A3_Q2 {
//The logic of the program consist the usage of an array when the user prompt skiers. The skier prompt goes
// goes into the list with a do while loop that ask if the user wants to continue to input using boolean and if else statements.
//The program start welcoming a warm message. Then it ask for skiers names and times and could be repeated by changing skier if the user
// agrees and its evaluated with the if else statement. The usage of an input next line and the if statement 
// is to let the user input any name. The user could even enter a space and a number wihtout affecting the double value for time.
// The if condition helps to take a line so that the skier time input do not be on the same line as it time input.
//The first if else statement evaluates the index positions and initialize it as 0,1 as the first position and second position of the array
// depending on the value given , it swaps the index with an if else statement. The program updates the three first index of the list 
// it do not sort the rest of the list. If a time prompted is superior to secondPositionIndex , it will initialize index = 2 for the thirdPositionIndex
// if it is inferior to the previous third it will swap the thirdPositionIndex with the current index.
// After, the if condition set is to display the podium. At the end of the program after the do while loop, a if statement is used to 
// print the final podium and an exit message.
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		 double []skierTime = new double [20]; // list for time in double up to 20 elements
		 String [] skierName = new String [20]; // list for name in string up to 20 elements
		// initialize index at -1 means not in list yet
		 int firstPositionIndex=-1; // best time
		 int secondPositionIndex=-1;// second best time
		 int thirdPositionIndex=-1; // third best time
		 
		
		 // display welcome message
		 System.out.println("Welcome to Mont-Halloween Skiing Contest Ranker.");
		 System.out.println("Whenever a skier makes it to the finish line, enter their name and skiing time.");
		 int index=0; // initialize index at 0 at the beginning of a array
		
		 do { // do while looop execute before checking condition
			 
			 System.out.print("Please input the skier's name: "); // prompt name
			 String name = input.nextLine();
			 
			 if(name.equals("")) //condition that is always true when user prompt a name for keyboard to use a line  (junk function)
				 name= input.nextLine();// name could be used as a space thanks to a if condition for example skier 1 
			 skierName[index] = name; // the name input goes to the array as 0
			 
			 System.out.print("Please input the skier's time: ");// time
			 double time = input.nextDouble();
			
	         skierTime[index] = time; // goes to the array as 0
	         
	         if (index==0) { // condition to initialize firstPositionIndex
	        	 firstPositionIndex=0;
	        
	         }
	         else if(index==1) { //condition to initialize second position index as the second in the list
	        	 if (skierTime[0]<skierTime[1])
	        		 secondPositionIndex =1;
	         
	             else { //swap position if needed depend on time user prompt
	        	      firstPositionIndex =1;
	        	      secondPositionIndex=0;}
	        	 
	         }
	         else { // condition else when index higher than 1
	        	 if(time<skierTime[firstPositionIndex]) { //time shorter than 1st , update the 3 podiums
	        		 thirdPositionIndex= secondPositionIndex;// second becomes third
	        		 secondPositionIndex = firstPositionIndex;// first becomes second
	        		 firstPositionIndex = index; // new becomes first 
	        	 }
	        	 
	        	 else if (time>skierTime[firstPositionIndex]&&time<skierTime[secondPositionIndex]) { //condition new second position
	        		 thirdPositionIndex= secondPositionIndex;// second becomes third
	        		 secondPositionIndex = index; // the new time becomes second
	        	}	 
	        	 
	        	 else if (time>skierTime[secondPositionIndex]) { //condition when time longer than second nested
	        		 if(index==2) //if index is =2 
	        			 thirdPositionIndex= index; //initialize thirdpositionindex at index at 2 
	        		 else if (time<skierTime[thirdPositionIndex]) // if time prompt is the new third position
	        			 thirdPositionIndex= index; // new time index is at third position
	        	 } 
	         }
	         
	         // condition for print podium, updates with if condition
	         	
			 if (index>=0)
				System.out.println("First podium goes to "+skierName[firstPositionIndex]+" who made it in "+skierTime[firstPositionIndex]+" second(s)"); 
			 if (index>=1)
				System.out.println("Second podium goes to "+skierName[secondPositionIndex]+" who made it in "+skierTime[secondPositionIndex]+" second(s)"); 
			 if (index>=2)
				System.out.println("Third podium goes to "+skierName[thirdPositionIndex]+" who made it in "+skierTime[thirdPositionIndex]+" second(s)"); 
			
			 
		    System.out.print("Do you want to add another skier? y/yes: "); //user prompt wish
			String answer = input.next();	 
				     
				     
			if (!answer.equals("y") && !answer.equals("yes")) { // condition if want to continue
				break; // break out of loop if answer is not equal to ...
			}
			index++;  // index is incremented by 1 post
			 
			
		 }while (index<20); // loop that index can not be reach to 20 
		 // print final podium before exiting game with goodbye message
		 
		 if (index >= 0)
             System.out.println("First podium goes to " + skierName[firstPositionIndex] + " who made it in " + skierTime[firstPositionIndex] + " second(s)");
         if (index >= 1)
             System.out.println("Second podium goes to " + skierName[secondPositionIndex] + " who made it in " + skierTime[secondPositionIndex] + " second(s)");
         if (index >= 2)
             System.out.println("Third podium goes to " + skierName[thirdPositionIndex] + " who made it in " + skierTime[thirdPositionIndex] + " second(s)");
         System.out.println("Goodbye!");

			 		 
	}
	}
