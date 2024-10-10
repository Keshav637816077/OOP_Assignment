/***
*Week 5 OOP's Assignment - Quiz Program
*
*This is the Subject class of the main quiz Program in which the questions get grouped in the sets according to name.
*
*Name - Keshav Kumar
*Date - 07.10.2024
*/


import java.util.Scanner;

class Subject {
    public static Scanner input = new Scanner(System.in);
    public String name;
    public Subject[] subjects;
    public int subjectCount;
    public Question[] questions;
    public int questionCount;

	//This constructor takes the name of subject and max number of subjects as inputs and saves.
	//Input Parameter - Subject name
    public Subject(String name, int maxQuestions) {
        this.name = name;
        this.subjects = new Subject[maxQuestions];
        this.questions = new Question[maxQuestions];
        this.subjectCount = 0;
        this.questionCount = 0;
    }

	//This method creates a new subject .
	//Input parameter - inputSubjectName.
	//return - no return type.
    public void addSubject(String subjectName) {
        if (subjectCount < subjects.length) {
            subjects[subjectCount] = new Subject(subjectName, 100);
            subjectCount++;
            System.out.println(Constant.SUBJECT_ADDED);
        } else {
            System.out.println(Constant.MAX_SUBJECT);
        }
    }
	
	//This method adds questions to the subject .
	//Input Parameter - Subject name, Question text, Options and Answers.  
	//return - no return type.
    public void addQuestionToSubject(String subjectName, String questionText, String[] options, char answer) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i].getName().equals(subjectName)) {
                subjects[i].addQuestion(questionText, options, answer);
                return;
            }
        }
        System.out.println(Constant.SUBJECT_NOT_FOUND);
    }
	
	//This method takes questions from the array and store in the subjects.
	//Input Parameter - Question array, option array and answers.
	//Return - no return type.
    public void addQuestionsFromArray(String[] questionTexts, String[][] options, char[] answers) {
        for (int i = 0; i < questionTexts.length; i++) {
            addQuestion(questionTexts[i], options[i], answers[i]);
        }
    }

    public static void main(String[] args) {
        System.out.print(Constant.ENTER_SUBJECT);
        String subjectName = input.nextLine();
        Subject mySubject = new Subject(subjectName, 100);
        mySubject.addSubject(subjectName);
    }
}
