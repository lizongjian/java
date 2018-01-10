package com.wuzhou.test07interface;
//工厂方法设计模式
public class TestFactoryMethod {
	public static void main(String[] args) {
		IWorkFactory i =new StrudentWorkFactory();
		i.getWork().doWork();
		
		IWorkFactory i1 = new TeachertWorkFactory();
		i1.getWork().doWork();
	}
}
interface IWorkFactory{
	Work getWork();
}
class StrudentWorkFactory implements IWorkFactory{

	public Work getWork() {
		return new StudentWork();
	}
	
}
class TeachertWorkFactory implements IWorkFactory{

	public Work getWork() {	
		return new TeacherWork();
	}
	
}

interface Work{
	public abstract void doWork();
}


class StudentWork implements Work{

	public void doWork() {
		System.out.println("学生写作业");
	}
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("老师写作业");		
	}
	
}