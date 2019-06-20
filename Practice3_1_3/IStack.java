package Practice3_1_3;

public interface IStack {
	public void clear(); 
	public boolean isEmpty(); 

	public int length();

	public Object peek();

	public Object pop();
	public void push(Object o) throws Exception;

	public void display();
}
