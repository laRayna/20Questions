import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//import QuestionsGame.QuestionNode;
import java.io.*;
public class questionTreeTester
{
    QuestionNode overallRoot;
    public static void main(String[] args) throws IOException{
        questionTreeTester tester = new questionTreeTester();
        BinaryTreePrinter printer = new BinaryTreePrinter();

        Scanner file = new Scanner(new File("spec-questions.txt"));
        printer.printPreOrder(System.out, tester.treeMaker(file)); 
    }

    public QuestionNode treeMaker(Scanner input) 
    {
        //Paste your QuestionGame constructor code here and return your overall Root once the tree is made.
    	ArrayList<String> list = new ArrayList<>();
		while(input.hasNextLine())
		{
			String str = input.nextLine();
			
			list.add(str);
		}
		
		add(overallRoot, list);

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
//	overallRoot = pointer;
//	System.out.print(overallRoot.data);

}
class QuestionNode
{
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

class BinaryTreePrinter {

    public BinaryTreePrinter() {}
    
    //Assumes your nodes have data, left and right
	private String traversePreOrder(QuestionNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        
        String pointerRight ="[R]--";
        String pointerLeft = (root.right != null) ? "[L]--" : "[L]--";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }
    private void traverseNodes(StringBuilder sb, String padding, String pointer, QuestionNode node, boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("|    ");
            } else {
                paddingBuilder.append("     ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "[R]--";
            String pointerLeft = (node.right != null) ? "[L]--" : "[L]--";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);

        }

    }

    public void printPreOrder(PrintStream os, QuestionNode overallRoot) {
        os.print(traversePreOrder(overallRoot));
    }


}