
public class ArrayTest {
	public static void main(String[] args) {
		int[] arr = new int[]{23,11,44,33,551,-1};
		ArrayUtil au  = new ArrayUtil();
		System.out.println(au.getMax(arr));
		
		System.out.println(au.getSum(arr));
		au.inverted(arr);
		for(int ar:arr){
			System.out.println(ar);
		}
		System.out.println(ArrayTest.class.getResource("/"));
	}

}
