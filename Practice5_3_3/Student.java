package Practice5_3_3;

public class Student {
   public int num;
   public String name;
   public int English;
   public int Math;
   public int Total;
   public Student(int num,String name,int English,int Math) {
	   this.num=num;
	   this.name=name;
	   this.English=English;
	   this.Math=Math;
	   this.Total=Math+English;
}  
   public void display() {
	System.out.println("学号："+num+"   姓名："+name+"    英语："+English+"    数学："+Math+"    总分："+Total);
}
}
