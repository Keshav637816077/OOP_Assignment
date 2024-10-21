/***
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
    public int subjectCount = 10;
    public Question[] questions;
    public int questionCount;

    public Subject(String name, int maxQuestions) {
        this.name = name;
        this.subjects = new Subject[maxQuestions];
        this.questions = questions.questionArray[maxQuestions];
        this.subjectCount = 0;
        this.questionCount = 0;
    }
	public static void display(){
		System.out.println(Constant.SUBJECT_LIST_MESSAGE);
		for(int i = 0; i < subjectCount; i++){
			System.out.prinln(Constant.SUBJECT_DISPLAY_MESSAGE, (i+1), subjects[i].toString());
		}
	}
    public void push(String subjectName) {
        if (subjectCount < subjects.length) {
            subjects[subjectCount] = new Subject(subjectName, 100);
            subjectCount++;
            System.out.println(Constant.SUBJECT_ADDED);
        } else {
            System.out.println(Constant.MAX_SUBJECT);
        }
    }

    public void pushQuestion(String subjectName, String questionText, String[] options, char answer) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i].getName().equals(subjectName)) {
                subjects[i].addQuestion(questionText, options, answer);
                return;
            }
        }
        System.out.println(Constant.SUBJECT_NOT_FOUND);
    }

    public void addQuestions(String[] questionTexts, String[][] options, char[] answers) {
        for (int i = 0; i < questionTexts.length; i++) {
            addQuestion(questionTexts[i], options[i], answers[i]);
        }
    }

    public String getName() {
        return name;
    }

    public questions getQuestions() {
        return questions;
    }
}