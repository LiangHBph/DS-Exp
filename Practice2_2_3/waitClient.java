package Practice2_2_3;

public class waitClient {
       String name;
       int ticketNum;//Ʊ��
       waitClient next;
       public waitClient(String name,int ticketNum) {
    	   this.name=name;
    	   this.ticketNum=ticketNum;
    	   next=null;
	}  
       
}
