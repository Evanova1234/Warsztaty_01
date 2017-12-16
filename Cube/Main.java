package Cube;

import java.util.Random;

public class Main {

	public static void main(String[] args) { 
		
		System.out.println(randomCube("4D10+10"));	
	}
	
	static int randomCube(String input) { 
		
		int numberOfThrows = computeThrows(input); 
		int typeOfCube = determineCube(input); 
		int additionalValue = calculateAddition(input);
		System.out.println("Mamy "+numberOfThrows+" rzutów, kostką o liczbie ścian "+typeOfCube+". A do całości dodajemy "+additionalValue);
		int result = 0; 
		int throwCase = 0; 
		Random throwCube = new Random();
		
		for(int i=0; i<numberOfThrows; i++) { 
			
			throwCase = throwCube.nextInt(typeOfCube)+1;
			System.out.println("Przy rzucie "+(i+1)+" wyszło "+throwCase);
			result += throwCase; 
		}
		return result+additionalValue; 
	}
	
	static int determineCube(String input) { 
		int startPosition = input.indexOf("D");
		if(input.indexOf("+")>=0) { 
			int endPosition = input.indexOf("+"); 
			return Integer.parseInt(input.substring(startPosition+1, endPosition));
		} else { 	
			return Integer.parseInt(input.substring(startPosition+1));
		}
	}
	
	static int calculateAddition(String input) { 
		int startPosition = input.indexOf("+"); 
		return Integer.parseInt(input.substring(startPosition+1));
	}
	
	static int computeThrows(String input) { 
		int startPosition = input.indexOf("D");
		if(startPosition == 0) { 
			return 1; 
		} else { 
			return Integer.parseInt(input.substring(0, startPosition));			
		}
	}
	
}
