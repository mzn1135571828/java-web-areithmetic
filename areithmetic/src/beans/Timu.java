package beans;

public class Timu {
	private int num1;
	private String oper;
	private int num2;
	private int result;
	public Timu() {
		// TODO 自动生成的构造函数存根
		create();
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return num1 +oper +num2 + "=";
	}
	public void create(){
		setNum1((int) (Math.random()*100)+1);
		setNum2((int) (Math.random()*100)+1);
		int i = (int) (Math.random()*4);
		switch(i){
			case 0:oper="+";break;
			case 1:oper="-";break;
			case 2:oper="*";break;
			case 3:oper="/";break;
		}
		while(oper=="-"&& num1<num2){
			setNum1((int)(Math.random()*100)+1);
			setNum2((int)(Math.random()*100)+1);
		}
		while(oper=="/"&& num1%num2!=0 ||oper=="/"&& num1<num2){
			setNum1((int)(Math.random()*100)+1);
			setNum2((int)(Math.random()*100)+1);
		}
		switch(oper){
			case "+":setResult(num1+num2);break;
			case "-":setResult(num1-num2);break;
			case "*":setResult(num1*num2);break;
			case "/":setResult(num1/num2);break;
		}
	}
}
