import java.io.*;
import java.util.*;

public class newTester {

	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(new File("spec-questions.txt"));
    	QuestionsGame g = new QuestionsGame(sc);
    }
}
