class MissingChar{
	public static void main(String[] args){
	
		//missingChar("Robocop", 4);

		if(args.length >= 2){
			
			missingChar(args[0], Integer.parseInt(args[1]));
		}
	}

	private static void missingChar(String str, int n){
		
		String newStr = "";

		newStr = str.substring(0, n - 1);
		newStr = newStr + str.substring(n);

		System.out.println(newStr);
	}
}
