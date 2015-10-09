package naren.core.string.algorithms;

public class StringMath {

	/*
	 * The following solution may  work for others also
	 * 9 / 2 / 2
	 * 8 * 2 / 1
	 * it won't work for + + or - - . will develope soon and check in. (WIP)
	 */
	public static void main(String[] args) {
		test("- 2 + 3 + 5 * 1 - 2 + 8 / 2 / 2");
		System.out.println("-----------------------------------");
		test("- 12 * 5 + 3 + 5 * 1 - 2 + 6 / 2");
		System.out.println("-----------------------------------");
		test("6 * 2 * 2");
		System.out.println("-----------------------------------");
		test("9 / 2 * 2");
	}
	
	public static void test(String str){
		str = str.trim();
		String full[] = str.split(" ");
		int result=0;
		int prev,next;
		System.out.println("given string : "+str);
		//first deal with / & & approaches 
		for(int j=0;j<2;j++){
			for(int i=0;i<full.length;i++){
				if(j==0 && full[i].equals("/")){
					prev=Integer.parseInt(full[i-1]);
					next = Integer.parseInt(full[i+1]);
					result=prev/next;
					str=str.replace(prev+" / "+next, ""+result);
					full=str.split(" ");
					i=0;
				}else if(j==1 && full[i].equals("*")){
					prev=Integer.parseInt(full[i-1]);
					next = Integer.parseInt(full[i+1]);
					result=prev*next;
					str=str.replace(prev+" * "+next, ""+result);
					full=str.split(" ");
					i=0;
				}
			}
		}
		System.out.println("after (/,*) operation:"+str);
		//60 + 2 - 3 - 1 - 39 + 10
		full=str.split(" ");
		result=0;
		for (int i = 0; i < full.length; i++) {
			if (full[i].equals("+")) {
				i=i+1;
				result = result + Integer.parseInt(full[i]);				
			} else if (full[i].equals("-")) {
				i=i+1;
				result = result - Integer.parseInt(full[i]);
			}else{
				result = result + Integer.parseInt(full[i]);
			}
		}
		
		System.out.println("result ---->"+result);
	}
	
	
}
