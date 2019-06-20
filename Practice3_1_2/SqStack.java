package Practice3_1_2;

public class SqStack implements IStack{
    int top;
    Object[] stackElem;
    public SqStack(int maxSize) {
		// TODO Auto-generated constructor stub
    	stackElem=new Object[maxSize];
    	top=0;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}else
		return stackElem[top-1];
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		if (top==stackElem.length) {
			throw new Exception("Õ»ÒÑÂú£¡");
		}else
		stackElem[top++]=x;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}else
		return stackElem[--top];
	}
	public void display() {
		for (int i =top-1; i >=0; i--) {
			System.out.print(stackElem[i].toString()+"");
		}
	}

}
