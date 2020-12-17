class ClosestNeighbours{

	public static void main(String[] args){
		
		int[] array = {0, 5, 1200, 6, 2, 32, 3, 30};
		int [] result = findClosest(array);

		System.out.println(result[0] + " - " + result[1]);
	}

	private static int[] findClosest(int[] numbers){
		
		int arraySize = numbers.length;
		int minDiff = 0;
		int[] theArray =new int[2];
		int firstIndex = 0;
		int secondIndex = 1;
		
		minDiff = Math.abs(numbers[0] - numbers[1]);
		
		for(int i = 0; i < arraySize - 1; i++){
			
			int num1 = numbers[i];
			int num2 = numbers[i+1];
			int currentDiff;
			
			currentDiff = Math.abs(num1 - num2);

			// < for the first closest min diff pair, <= for the last closest min diff pair
			if(currentDiff <= minDiff){
			
				minDiff = currentDiff;
				firstIndex = i;
				secondIndex = i + 1;
			}

		}

		theArray[0] = numbers[firstIndex];
		theArray[1] = numbers[secondIndex];
		
		return theArray;
	}
}
