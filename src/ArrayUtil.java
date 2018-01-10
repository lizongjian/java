
public class ArrayUtil {
	//1.获取最大值
	public int getMax(int[] arr){
		int temp = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(temp<arr[i]){
				temp=arr[i];
			}
		}
		return temp;
	}
	//2.数组总和
	public int getSum(int[] arr){
		int temp = 0;
		for(int i =0;i<arr.length;i++){
			temp+=arr[i];
		}
		return temp;
	}
	//3.数组逆序
	public void inverted(int[] arr){
		for(int i =0,j =arr.length-1;i<j;i++,j--){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
}
