package Practice2_2_3;

public class waitClient {
       String name;
       int ticketNum;//Æ±ºÅ
       waitClient next;
       public waitClient(String name,int ticketNum) {
    	   this.name=name;
    	   this.ticketNum=ticketNum;
    	   next=null;
	}  
       
}
