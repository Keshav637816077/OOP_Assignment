/***
 * In this Assignment we make Quiz System based on subject in which the user get a question and Option and you have to answer the question by choosing the option
 * Program_owner : Kalpana Swami
 * Date : 09 October 2024
 */
import java.util.Scanner;
public class Main {
    private final static ResponseOption response = new ResponseOption();
	private final static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Subject[] subjects = new Subject[10];
        int subjectCount = 0;
        String option;
		String option1 = null;
        do {
            System.out.println(Constant.OPTION_PROMPT);
			System.out.println(Constant.MAKE_QUIZ_OPTION);
            System.out.println(Constant.TAKE_QUIZ_OPTION);
            System.out.println(Constant.EXIT_OPTION);
            System.out.print(Constant.ENTER_OPTION_PROMPT);
            option = input.nextLine();
            switch (option) {
                case "1":
                	response.create(subjects, subjectCount);
                    subjectCount++;
                    break;
                case "2":
                	response.test();
                    break;
                case "3":
                    System.out.println(Constant.EXIT_MESSAGE);
                    break;
                default:
                    System.out.println(Constant.INVALID_OPTION_MESSAGE);
                    break;
            }
			if (!option.equals("3")){
                System.out.println(Constant.CONTINUE_PROMPT);
                option1 = input.nextLine();
            }
        } while (option1.equals("1"));
        input.close();
    }
}
