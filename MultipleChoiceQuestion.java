
/** *
 * This file contain MultipleChoiceQuestion in which we display Question and option
 *
 * Program_owner : Kalpana Swami
 * Date : 07 October 2024
 */

public abstract class MultipleChoiceQuestion extends MultipleChoice {

    public MultipleChoiceQuestion(String questionText, String[] options) {
        super(questionText, options);
    }

    String Question;
    String UserAnswer;

    /* Display function is only displaying the Question and Options
        Parameter : String
        Return_type : No Return Type */

    public void display(String Question, String[] Options, int i) {
        this.Question = Question;
        System.out.println(Question + "\n" + Options[i]);
    }

    /* ValidAnswer function is used to check the Answer is correct or not
       Parameter : String
       Return_type : Boolean */
    public boolean isvalidAnswer(String Answer, String UserAnswer) {
        this.UserAnswer = UserAnswer;
        return Answer.equalsIgnoreCase(UserAnswer);
    }

}
