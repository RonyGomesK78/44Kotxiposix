import java.util.regex.*;

class Homework1{

	public static void main(String[] args){

		//System.out.println(isUrl("http://www.academia.pt.org"));
		homeWork1("https://www.academiadecodigo.pt.org");
	}



	private static void homeWork1(String url){
		

		if(isUrl(url)){
			
			
			String domain = "";
			String name = "";

			domain = url.substring(url.lastIndexOf("/", 7) + 1);
			//System.out.println(domain);
			
			//name = "< " +  url.substring(url.indexOf(".") + 1, url.indexOf(".", 12)).replaceFirst("a", "A").replaceFirst("co", "Co") + "_ >";
			//System.out.println(name);
			
			name = transformToName(domain);
			System.out.println("I am a Code Cadet at " + name + ", " + domain);

		}else{

			System.out.println("Your URL is not valid");
		}
		
	}


	private static String transformToName (String url){

		String name = url.substring(url.indexOf(".") + 1, url.indexOf(".", 4));
		
		int firstIndex = 0, lastIndex = 1;

		for(int i = 0; i < name.length(); i++){
			
			String isWord = name.substring(firstIndex, lastIndex); 
			lastIndex = i;
		
			if(isPtWords(isWord)){
				
				firstIndex = i;	
				System.out.println(isWord);
			}
		}
		return name;
	}

	private static boolean isPtWords(String word){

		for(int i = 0; i < PTWORDS.values().length; i++){
			
			System.out.println(PTWORDS.values()[i] + " : " + word);
			if(word.equals(PTWORDS.values()[i].toString())){
				
				System.out.println("yyy");		
				return true;
			}
		}

		return false;
	}

	private static boolean isUrl(String url){
	
		return Pattern.matches("http[s]?:[/]{2}[w]{3}\\.[a-z]{2,}(\\.[a-z]{2,3})+", url);
	}

	

	private enum PTWORDS{
		
		codigo, academia, de;
	}
}
