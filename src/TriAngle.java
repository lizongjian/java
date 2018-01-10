
public class TriAngle {
	public static void main(String[] args){
		Angle a = new Angle();
//		a.setBase(10);
//		a.setHeigth(20);
//		
		System.out.println(a.findArea());
	}

}
class Angle{
	private int base;
	private int heigth;
	public void setBase(int base){
		this.base=base;
	}
	public void setHeigth(int heigth){
		this.heigth=heigth;
	}
	public int findArea(){
		return base*heigth/2;
	}
	public Angle() {
		this.base=1;
		this.heigth=10;
	}
}