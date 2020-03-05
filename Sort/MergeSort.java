package Basic;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 2, 4 };
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
	
	public static void mergeSort(int arr[], int l, int r) {
		System.out.println("====before========="+"l: " + l + " r " + r);
		if (l < r) {
			int mid = (l + r) / 2;
			System.out.println("l: " + l + " mid " + mid+ " r " + r );
			System.out.println("=============");
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public static void merge(int arr[], int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = l;
		System.out.println("$$$$$$$$$$$$$$$$$$$i " + i + " j " + j + " k " + k);
		int temp[] = new int[arr.length];
		while (i <= mid && j <= r) {
			System.out.println("arr[" + i + "] " + arr[i] + " arr[" + j + "] " + arr[j]);
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= r)
			temp[k++] = arr[j++];
		
//		  if (i > mid) {
//	            for (int index = j;  index <=r ;  index++, k++)
//	            	temp[k] = arr[index];
//	        } else {
//	            for (int index = i; index <= mid; index++, k++)
//	            	temp[k] = arr[index];
//	        }


		
		for (int index = l; index < k; index++) {
			System.out.println("index: "+index+" k "+k);
			System.out.println("arr[" + index + "] " + arr[index] + " temp[" + index + "] " + temp[index]);
			arr[index] = temp[index];
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

//	public static int[] sorted = new int[30];
//
//	public static void mergeSort(int[] arr, int m, int n) {
//		int middle;
//		if (m < n) {
//			middle = (m + n) / 2;
//			mergeSort(arr, m, middle);
//			mergeSort(arr, middle + 1, n);
//			merge(arr, m, middle, n);
//		}
//	}
//
//	public static void merge(int[] arr, int m, int middle, int n) {
//		int i, j, k, t;
//
//		i = m;
//		j = middle + 1;
//		k = m;
//
//		while (i <= middle && j <= n) {
//			if (arr[i] <= arr[j])
//				sorted[k] = arr[i++];
//			else
//				sorted[k] = arr[j++];
//			k++;
//		}
//
//		if (i > middle) {
//			for (t = j; t <= n; t++, k++)
//				sorted[k] = arr[t];
//		} else {
//			for (t = i; t <= middle; t++, k++)
//				sorted[k] = arr[t];
//		}
//
//		for (t = m; t <= n; t++) {
//			arr[t] = sorted[t];
//			System.out.println("\n for>> ");
//			printArray(arr);
//
//		}
//			
//
//		System.out.println("\n Merge Sort >> ");
//
//	}

	// 1

	

}
