import java.util.Scanner;

public class Encrypt {
	
	public static int putBack(int a, int b, int c, int d) {
		
		int newFourDigitNumber = 0;
		
		a *= 1000;
		b *= 100;
		c *= 10;
		
		newFourDigitNumber = a + b + c + d;
		
		return newFourDigitNumber;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int fourDigitNumber;
		int digit1;
		int digit2;
		int digit3;
		int digit4;
		int temp;
		
		System.out.println("Enter a 4 digit number to encrypt: ");
		fourDigitNumber = in.nextInt();
		
		digit1 = fourDigitNumber / 1000;
		digit2 = (fourDigitNumber / 100) % 10;
		digit3 = (fourDigitNumber % 100) / 10;
		digit4 = fourDigitNumber % 10;
		
		digit1 = (digit1 +7) % 10;
		digit2 = (digit2 +7) % 10;
		digit3 = (digit3 +7) % 10;
		digit4 = (digit4 +7) % 10;
		
		temp = digit1;
		digit1 = digit3; //swap 1 & 3
		digit3 = temp;
		
		temp = digit2;
		digit2 = digit4;//swap 2 & 4
		digit4 = temp;
		
		fourDigitNumber = putBack(digit1, digit2, digit3, digit4);
		
		System.out.printf("\nThe encrypted code is: %d", fourDigitNumber);
		
		in.close();
		
	}

}
