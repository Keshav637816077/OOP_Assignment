/***
*This is the Subject class of the main quiz Program in which the questions get grouped in the sets according to name.
*
*Name - Keshav Kumar
*Date - 07.10.2024
*/

class Subject {
    private String name;
    private Subject[] subjects;
    private int subjectCount;
    private Question[] questions;
    private int questionCount;

    /***
     * Constructor to initialize a subject with a name and a maximum number of questions.
     * 
     * @param name
     * @param maxQuestions
     */

    public Subject(String name, int maxQuestions) {
        this.name = name;
        this.subjects = new Subject[maxQuestions];
        this.questions = new Question[maxQuestions];
        this.subjectCount = 0;
        this.questionCount = 0;
    }

    /***
     * Method to display all Subjects.
     */
    public void display() {
        System.out.println(Constant.SUBJECT_LIST_MESSAGE);
        for (int i = 0; i < subjectCount; i++) {
            System.out.printf(Constant.SUBJECT_DISPLAY_MESSAGE, (i + 1), subjects[i].toString());
        }
    }

    /***
     * Method to add a new subject.
     * 
     * @param subjectName
     */

    public void addSubject(String subjectName) {
        if (subjectCount < subjects.length) {
            subjects[subjectCount] = new Subject(subjectName, 100);
            subjectCount++;
            System.out.println(Constant.SUBJECT_ADDED_MESSAGE + subjectName);
        } else {
            System.out.println(Constant.ERROR_MAX_SUBJECT);
        }
    }


    /***
     * Method to add a question to a specific subject.
     * 
     * @param subjectName
     * @param questionText
     * @param options
     * @param answer
     */
    public void addQuestionToSubject(String subjectName, String questionText, String[] options, char answer) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i].getName().equals(subjectName)) {
                subjects[i].addQuestion(questionText, options, answer);
                return;
            }
        }
        System.out.println(Constant.ERROR_SUBJECT_NOT_FOUND);
    }

    /***
     * Method to add a question to the subject's question list.
     * 
     * @param questionText
     * @param options
     * @param answer
     */

    public void addQuestion(String questionText, String[] options, char answer) {
        if (questionCount < questions.length) {
            questions[questionCount] = new Question(questionText, options, answer);
            questionCount++;
            System.out.println(Constant.QUESTION_ADDED);
        } else {
            System.out.println(Constant.MAX_LIMIT);
        }
    }

    /***
     * Method to get the subject's name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /***
     * Method to print all questions for the subject.
     */
    public void printQuestions() {
        System.out.println(Constant.QUESTION + name);
        for (int i = 0; i < questionCount; i++) {
            System.out.println(questions[i].toString());
        }
    }

    public class Question {
        private String questionText;
        private String[] options;
        private char answer;

        /***
         * Constructor to initialize the question with text, options, and the correct answer.
         * 
         * @param questionText
         * @param options
         * @param answer
         */
        public Question(String questionText, String[] options, char answer) {
            this.questionText = questionText;
            this.options = new String[options.length];
            for (int i = 0; i < options.length; i++) {
                this.options[i] = options[i];
            }

            this.answer = answer;
        }

        /***
         * Method to return the question text along with the options.
         * 
         * @return result
         */

        public String quizQuestions() {
            String result = Constant.QUESTION1 + questionText + "\n";
            for (int i = 0; i < options.length; i++) {
                result += (char) ('A' + i) + ". " + options[i] + "\n";
            }
            result += Constant.CORRECT + answer;
            return result;
        }
    }
}
