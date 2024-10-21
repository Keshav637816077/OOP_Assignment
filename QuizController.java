/*
* Name : Rahul Ganeshwar Patil
* Date : 08-10-2024
* Descripton : [This file manages Quiz. It Displays questions, options and update score according to the correct answer.]
*/

import java.util.Scanner;

public class QuizController {
    private int score = 0;
    final Scanner input = new Scanner(System.in);
	private MultipleChoiceQuestion MCQ;
	final QuestionBuilder questionSet = new QuestionBuilder();
    final Question[] questions;
	final String[] options = null;
    final UserAccount user;
	
    public QuizController(Question[] questions,String[] options ,UserAccount user) {
        this.questions = questions;
        this.user = user;
    }
	
    public void addScore(String userChoice) {
        if (MCQ.isValidAnswer(userChoice)) {
            score++;
        } else {
            score -= 2;
        }
    }
	
    public void displayScore() {
        System.out.printf(Constant.SCORE_DISPLAY_MESSAGE,user.getName(), user.getScore(), questions.length);
    }
	
    public void conductQuiz() {
        for (int i = 0; i < questionSet.sizeOfArray; i++ ) {
            MCQ.display(questionSet.questionsArray[i],questionSet.optionsArray[i],i);            
            System.out.println(Constant.PROMPT_ENTER_OPTION);
            String userAnswer = input.nextLine();
			if (!isValidInput(userAnswer)) {
                System.err.println(Constant.VALID_INPUT_ERROR);
            } 
			else if (userAnswer.equalsIgnoreCase("submit")) {
				System.out.println(Constant.SUBMITTING_MESSAGE);
				user.setScore(score);
				displayScore();
            } 
			else{
				addScore(userAnswer);
			}            
        }
    }
	
	private boolean isValidInput(String input) {
        return input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B") || 
               input.equalsIgnoreCase("C") || input.equalsIgnoreCase("D") || 
               input.equalsIgnoreCase("submit");
    }
}