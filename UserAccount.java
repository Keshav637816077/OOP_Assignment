/***
*This is the UserAccount class of the main quiz Program in which the user name gets added and score gets added according to that. 
*
*Name - Keshav Kumar
*Date - 07.10.2024
*/
class UserAccount {
    String name;
	String rollNumber;
    int score;

    public UserAccount(String name, String rollNumber) {
        this.name = name;
		this.rollNumber = rollNumber;
        this.score = 0;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}