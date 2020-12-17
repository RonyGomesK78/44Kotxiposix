class NotString{

	public static void main(String[] args){
		
		//notString(" Mission");
		
		
		if(args.length > 0){
			
			notString(args[0]);
		}
	}

	private static void notString(String str){
		
		String theNot = "not ";

		if(str.length() >= 4){

			System.out.println(theNot.equals(str.substring(0, 4))? str : theNot + str);
		}

		else{
			System.out.println(theNot + str);		
		}

	}
}
