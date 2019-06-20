package Practice2_2_3;

public class bookedClient extends waitClient{
    int grade;
    bookedClient next;
	public bookedClient(String name, int ticketNum) {
		super(name, ticketNum);
	}
	public void setGrade(int grade) {
		this.grade=grade;
	}

}
