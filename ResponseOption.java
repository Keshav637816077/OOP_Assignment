/*
* Name : Rahul Ganeshwar Patil
* Date : 09-10-2024
* Description : [This file helps to shorten Quiz Creator as nested options are handled here.]
**/

import java.util.Scanner;
public class ResponseOption {
    static Scanner input = new Scanner(System.in);
    static String option;
	static QuestionBuilder QuestionSet;
    static QuizController quiz;
    public void create(Subject[] subjects, int subjectCount) {
        System.out.println(Constant.SHOW_SUBJECTS_OPTION);
        System.out.println(Constant.ADD_SUBJECT_OPTION);
        System.out.println(Constant.EXIT_OPTION);
        System.out.print(Constant.ENTER_OPTION_PROMPT);
        option = input.nextLine();
        switch (option) {
            case "1":
                for (int i = 0; i < subjectCount; i++) {
                    if (subjects[i] != null) {
                        System.out.println("Subject " + (i + 1) + ": " + subjects[i].getName());
                    }
                }
                break;
            case "2":
                System.out.print(Constant.ADD_SUBJECT);
                String subjectName = input.nextLine();
                subjects[subjectCount] = new Subject(subjectName, 100);
                System.out.println(Constant.SUBJECT_ADDED_MESSAGE+ subjectName);
                QuestionBuilder.generate();
                break;
            case "3":
                System.out.println(Constant.EXIT_MESSAGE);
                return;
            default:
                System.out.println(Constant.INVALID_OPTION_MESSAGE);
                break;
        }
    }

    public void test() {
        System.out.println(Constant.CHOOSE_SUBJECT_PROMPT);
        System.out.println(Constant.CHOOSE_SUBJECT_OPTION);
        System.out.println(Constant.START_TEST_OPTION);
        System.out.println(Constant.EXIT_TEST_OPTION);
        System.out.print(Constant.ENTER_OPTION_PROMPT);
        option = input.nextLine();
        switch (option) {
            case "1":
				Subject.display();
                break;
            case "2":
				System.out.println(Constant.ENTER_USER_DETAILS);
				String name = input.nextLine();
				String rollNo = input.nextLine();
				UserAccount User = new UserAccount(name, rollNo);
                quiz.conductQuiz();
                break;
            case "3":
                System.out.println(Constant.EXIT_MESSAGE);
                return;
            default:
                System.out.println(Constant.VALID_INPUT_ERROR);
                break;
        }
    }
}
