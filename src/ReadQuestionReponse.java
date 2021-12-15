import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadQuestionReponse {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		QuestionReponseIHM questionReponse= null;
		QuestionReponseIHM1 questionReponse1= null;
		 FileInputStream fileIn = new FileInputStream("C:\\Users\\hp\\Desktop\\dev java\\QuestionReponse\\WriteQuestionReponse");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        questionReponse=  (QuestionReponseIHM) in.readObject();
	        questionReponse1=  (QuestionReponseIHM1) in.readObject();
	}

}
