package beans;

public class ComputerBean {
	private float a;
	private float b;
	private char ch;
	private float result;

	public ComputerBean(float a,float b,char ch) {
		this.a=a;
		this.b=b;
		this.ch=ch;
	}

	public void cacuResult() {

		switch(ch) {
			case 43:result= a+b;break;
			case 45:result= a-b;break;
			case 42:result= a*b;break;
			case 47:if(b==0) {
				result=-1;
				break;
			}
			else
				result=a/b;
		}
	}

	public float getA() {
		return a;
	}
	public float getB() {
		return b;
	}
	public char getCh() {
		return ch;
	}
	public float getResult() {
		return result;
	}
}


