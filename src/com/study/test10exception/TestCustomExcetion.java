package com.wuzhou.test10exception;

public class TestCustomExcetion {
	public static void main(String[] args) {
		Student student = new Student();
		try {
			student.regist(-10);
		} catch (CustonExcetion e) {
			System.out.println(e.getMessage());
		}
	}

}
class Student{
	int id;
	public void regist(int id) throws CustonExcetion{
		if(id>0){
			this.id=id;
		}else{
			throw new CustonExcetion("输入错误");
		}
	}	
}
