import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入学生个数");
		Scanner s = new Scanner(System.in);
		int count=s.nextInt();
		int[] scores = new int[count];
		int maxScores = 0;
		System.out.println("输入"+count+"个学生成绩");
		for(int i =0;i<scores.length;i++){
			scores[i] =s.nextInt();
			if(scores[i]>maxScores){
				maxScores=scores[i];
			}
		}
		System.out.println("最高分为："+maxScores);
		s.close();
	}
		
}
