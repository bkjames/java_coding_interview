package Basic;

public class SplitTest {
	
	public static void main(String[] args) {
		
		//1
		String str = "I love you ~~!";
		String[] words = str.split("\\s");
		
		for(String word: words)
			System.out.println(word);
		
		//2
		String str2 =  "phone;;name;id;pwd";
		String word  = str2.split(";")[0];
		String word2 = str2.split(";")[1];
		String word3 = str2.split(";")[2];
		
		System.out.println(word);
		System.out.println(word2);
		System.out.println(word3);
		System.out.println();
		
		//3
		 String str1 = "phone;name;id;pwd";
	        String[] words1 = str1.split(";", 0);
	        String[] words2 = str1.split(";", 2);
	         
	        System.out.println("0 일때 : ");
	        for (String wo : words1 ){
	            System.out.println(wo);
	        }
	         
	        System.out.println("\r\n2 일때 : ");
	        for (String wo : words2 ){
	            System.out.println(wo);
	        }


		
	}

}
