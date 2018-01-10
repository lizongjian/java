package com.wuzhou.test07interface;

public class TestUSB {
	public static void main(String[] args) {
		computer computer = new computer();
		computer.dowork(new Flash());
		
		//接口的匿名内部类的对象
		USB phone = new USB() {
			
			@Override
			public void stop() {
				System.out.println("手机工作");
				
			}
			
			@Override
			public void start() {
				System.out.println("手机工作");
				
			}
		};
		computer.dowork(phone);
	}
	

}
class computer{
	public void dowork(USB s){
		s.start();
		s.stop();
	}
	
} 

interface USB{
	void start();
	void stop();
}
class Flash implements USB{

	@Override
	public void start() {
		System.out.println("U盘工作");
	}

	@Override
	public void stop() {
		System.out.println("U盘停止");
	}
}
class print implements USB{

	@Override
	public void start() {
		System.out.println("打印机工作");
	}

	@Override
	public void stop() {
		System.out.println("打印机停止");
	}
	
}