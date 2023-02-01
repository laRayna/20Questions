// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.util.*;
import java.io.*;

public class QuestionsGame {
	public TreeNode overallRoot;
	public int size;
	
	public QuestionsGame(String str)
	{
		overallRoot = new TreeNode(str);
		size = 1;
	}
	
	public QuestionsGame(Scanner input)
	{
		ArrayList<String> list = new ArrayList<>();
		while(input.hasNextLine())
		{
			String str = input.nextLine();
			if(str.length() > 2)
			{
				list.add(str);
				System.out.print("added");
			}
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
		TreeNode pointer = overallRoot;
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
        // Your code here
		TreeNode root = new TreeNode("Does it do stuff");
    }
    
    
    
    
    
    
    
    
    private void add(TreeNode pointer, ArrayList<String> list)
    {
    	if (overallRoot == null)
    		overallRoot = new TreeNode(list.get(0));
    
    	
    }
    
    
    
	
	 private ArrayList<String> getQuestions(ArrayList<String> str, TreeNode pointer) {
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



