class FrontBack{
	
	public static void main(String args[]){
		
		if(args.length > 0){
			
			frontBack(args[0]);
		}
	}	

	
	private static void frontBack(String str){
		
		if(str.length() > 1){
		
			int lastIndex = str.length() - 1;
			String newStr = "";

			newStr = str.charAt(lastIndex) + str.substring(1, lastIndex) + str.charAt(0); 

			System.out.println(newStr);
		}
		else{

			System.out.println(str);
		}
	}
}
