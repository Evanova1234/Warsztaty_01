package guessGame_advanced;

import java.util.Scanner;

//zrobić jeszcze raz z casem i liczba linii <40. operujemy na zwykłych zmiennych. 

public class Main {

	public static void main(String[] args) {

		Scanner userAnswer = new Scanner(System.in);
		String answer="";
		int[] range = { 0, 1000 };
		int guess = 0;
		int x = 1; 
		
		System.out.println("Pomyśl liczbę między 0..1000");

		while (!"t".equals(answer)) {
			
			guess = guessNumber(range);
			
			System.out.println("Podejście "+x+". Zgaduję: " + guess+" Zgadłem? d/m/t");
			
			answer = userAnswer.next();
			
			if ("t".equals(answer)) {
				System.out.println("Wygrałem!");
			} else {
				range = narrowRange(range, guess, answer);
			}
			x++; 
		}
		
		userAnswer.close();

	}

	static int guessNumber(int[] range) {
		return (((range[1] - range[0]) / 2) + range[0]);
	}

	static int[] narrowRange(int[] range, int guess, String userAnswer) {
		int[] resultTable = new int[2];

		if ("d".equals(userAnswer)) {
			resultTable[0] = range[0];
			resultTable[1] = guess;
			return resultTable;
		}

		if ("m".equals(userAnswer)) {
			resultTable[0] = guess;
			resultTable[1] = range[1];
			return resultTable;
		} else {

			System.out.println("odpowiedziałeś niepoprawnie! Odpowiedz jeszcze raz");
			return range;
		}

	}

}
