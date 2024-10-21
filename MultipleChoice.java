
/** *
 * This file contain Question Class  *
 * Program_owner : Kalpana Swami
 * Date : 07 October 2024
 */
public abstract class MultipleChoice implements Question {

    String questionText;
    String[] options;
    String Answer;

    public MultipleChoice(String questionText, String[] options) {
        this.questionText = questionText;
        this.options = options;
    }

    public abstract void display(String Question, String Option, int index);

    public abstract boolean isValidAnswer(String userAnswer, String Answer);
}
