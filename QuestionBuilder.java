/*
* Name : Gulshan and Ayush
* Date : 07-10-2024
* Description : [This file takes Questions and their Options and its answer input from the creator in any subject.]
*/

import java.util.*;
public class QuestionBuilder{
    String[] questionsArray;
    String[][] optionsArray;
    int[] answerArray;
	int sizeOfArray;

	// This method takes Questions and their Options and its answer input from the creator.
    public static void generate() {
		String numberOfQuestion = "";
		String questionInput = "";
		String optionInput = "";
		String answerInput = "";
		Scanner input = new Scanner(System.in);
        while (numberOfQuestion.isEmpty()){
            System.out.println(Constant.PROMPT_NUMBER_OF_QUESTIONS);
            numberOfQuestion = input.nextLine();
            numberOfQuestion = numberOfQuestion.trim();
            if(numberOfQuestion.isEmpty()) System.out.println(Constant.ERROR_EMPTY_QUESTION);
            else {
                if(isvalidString(numberOfQuestion)){
                    sizeOfArray = Integer.parseInt(numberOfQuestion);
                }
                else {
                    System.out.println(Constant.ERROR_INVALID_INPUT);
                    numberOfQuestion = "";
                }
            }
        }
        questionsArray = new String[sizeOfArray];
        optionsArray = new String[sizeOfArray][4];
        answerArray = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++){
            questionInput = "";
            while (questionInput.isEmpty()){
                System.out.println("Enter question " + (i+1) + " : ");
                questionInput = input.nextLine();
                questionInput = questionInput.trim();
                if(questionInput.isEmpty()) System.out.println(Constant.ERROR_EMPTY_QUESTION);
                else storeQuestionIntoQuestionsArray(questionInput,i);
            }
            for(int j = 0; j < 4; j++){
                optionInput = "";
                while (optionInput.isEmpty()){
                    System.out.println("Enter option " + (j+1) + " : ");
                    optionInput = input.nextLine();
                    optionInput = optionInput.trim();
                    if(optionInput.isEmpty()) System.out.println(Constant.ERROR_EMPTY_OPTION);
                    else storeOptionIntoOptionsArray(optionInput, i, j);
                }
            }

            answerInput = "";
            while (answerInput.isEmpty()){
                System.out.println(Constant.PROMPT_CORRECT_OPTION);
                answerInput = input.nextLine();
                answerInput = answerInput.trim();
                if(answerInput.isEmpty()) System.out.println(Constant.PROMPT_CORRECT_OPTION);
                else{
                    if(isvalidString(answerInput)){
                        int valid = Integer.parseInt(answerInput);
                        if(valid >= 1 && valid <= 4) storeAnswerIntoAnswerArray(valid, i);
                        else{
                            System.out.println(Constant.INVALID_OPTION_MESSAGE);
                            answerInput = "";
                        }
                    }
                    else {
                        System.out.println(Constant.INVALID_OPTION_MESSAGE);
                        answerInput = "";
                    }
                }
            }
        }
        System.out.println(Constant.THANK_YOU_MESSAGE);
        System.out.println(Constant.QUIZ_READY_MESSAGE);
    }

	// This method ensures that the input String is always a positive integer.
	// Parameter - Trimmed input string entered by the userInput
	// Return - False if not a positive integer else return true 
    public boolean isvalidString(String userInput){
        int size = userInput.length();
        for(int i = 0; i < size; i++){
            if(!(userInput.charAt(i) >= '0' && userInput.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }

	// This method stores the question input by user into the question array.
	// Parameter - question and index
	// Return - Void
    public void storeQuestionIntoQuestionsArray(String question,int index){
        questionsArray[index] = question;
    }
	// This method stores the Option input by user into the option array.
	// Parameter - option and question index and option index.
	// Return - Void
    public void storeOptionIntoOptionsArray(String option, int index1, int index2){
        optionsArray[index1][index2] = option;
    }
	// This method stores the answer input by user into the answer array.
	// Parameter - answer and index
	// Return - Void
    public void storeAnswerIntoAnswerArray(int answer, int index){
        answerArray[index] = answer;
    }
}