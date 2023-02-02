// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.util.*;
import java.io.*;

public class QuestionsGame {
	public QuestionNode overallRoot;
	public int size;
	
	public QuestionsGame(String str)
	{
		overallRoot = new QuestionNode(str);
		size = 1;
	}
	
	public QuestionsGame(Scanner input)
	{
		ArrayList<String> list = new ArrayList<>();
		while(input.hasNextLine())
		{
			String str = input.nextLine();
			
			list.add(str);
		}
		
		add(overallRoot, list);
	}
	
	
	public void saveQuestions(PrintStream output)
	{
		if(output == null)
			throw new IllegalArgumentException("Your kinda retard");
		ArrayList<String> str = new ArrayList<String>();
		getQuestions(str, overallRoot);
		for(String x: str)
		{
			System.out.println(x);
		}
	}
	
	
	public void play()
	{
		System.out.println("hi");
		
		QuestionNode pointer = overallRoot;
		Scanner scn = new Scanner(System.in);
		
		while(pointer.left != null && pointer.right != null)
		{
			System.out.println(pointer.data);
			String temp = scn.nextLine();
			
			if(temp.trim().toLowerCase().startsWith("y"))
			{
				pointer = pointer.left;
			}
			else
			{
				pointer = pointer.right;
			}
		}
		System.out.println("Is the answer correct?");
		String ans = scn.nextLine();
		String object = "";
		String question = "";
		String nextans = "";
		String oldans = pointer.data;
		if(ans.trim().toLowerCase().startsWith("y"))
		{
			System.out.println("Ez dubs");
		}
		else
		{
			System.out.println("What is your object?");
			object = scn.nextLine();
			System.out.println("Give me a yes or no question that distinguishes between a" + object + " and " + pointer.data);
			question = scn.nextLine();
			System.out.println("is the answer yes for " + object);
			nextans = scn.nextLine();
			
			pointer.data = question;
			if(nextans.trim().toLowerCase().startsWith("y"))
			{
				pointer.left.data = object;
				pointer.right.data = oldans;
			}
			else
			{
				pointer.left.data = oldans;
				pointer.right.data = object;
			}
		}
		
		System.out.println("Do you want to play again?");
		String ans2 = scn.nextLine();
		if(ans2.trim().toLowerCase().startsWith("y"))
			play();
		else
			System.out.println("gg");
		
	}
	
	
    private static class QuestionNode {
        public String data;            //data stored at this node
        public QuestionNode  left;    //reference to left subtree
        public QuestionNode right;   //reference to right subtree

        // Constructs a leaf node with the given data
        public QuestionNode(String data)
        {
            this(data, null, null);
        }

        // Constructs a branch node with the given data and links
        public QuestionNode(String data, QuestionNode left, QuestionNode right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        
    }
    
    
    
    
    
    
    
    private void add(QuestionNode pointer, ArrayList<String> list)
    {
    	String qa = list.get(0);
    	list.remove(qa);
    	String info = list.get(0);
    	list.remove(info);
    	
    	if(qa.equals("Q") == true)
    	{
    		pointer = new QuestionNode(info);
        	
    		add(pointer.left, list);
    		add(pointer.right, list);
    		
    	
    	}	
    	else
    	{
    		pointer = new QuestionNode(info);    
    	}
//    	
//    	overallRoot = pointer;
//    	System.out.print(overallRoot.data);

    }
    
    
	
	 private ArrayList<String> getQuestions(ArrayList<String> str, QuestionNode pointer) {
		 if(pointer == null)
			 return str;
		 str.add(pointer.data);
		 if(pointer.left != null)
			 str = getQuestions(str, pointer.left);
		 if(pointer.right != null)
			 str = getQuestions(str, pointer.right);
		 return str;
	 }
}



