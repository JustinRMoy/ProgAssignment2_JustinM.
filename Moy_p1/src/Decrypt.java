import java.util.Scanner;

public class Decrypt {

	public static int decrypt(int a) {
		
		if(a == 7 || a == 8 || a == 9) {
			a -= 7;
		}else {
			a += 3;
		}
		
		return a;
		
	}
	
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
		
		System.out.println("Enter a 4 digit number to decrypt: ");
		fourDigitNumber = in.nextInt();
		
		digit1 = fourDigitNumber / 1000;
		digit2 = (fourDigitNumber / 100) % 10;
		digit3 = (fourDigitNumber % 100) / 10;
		digit4 = fourDigitNumber % 10;
		
		digit1 = decrypt(digit1);
		digit2 = decrypt(digit2);
		digit3 = decrypt(digit3);
		digit4 = decrypt(digit4);
		
		temp = digit1;
		digit1 = digit3; //swap 1 & 3
		digit3 = temp;
		
		temp = digit2;
		digit2 = digit4; //swap 2 & 4
		digit4 = temp;
		
		fourDigitNumber = putBack(digit1, digit2, digit3, digit4);
		
		System.out.printf("\nThe decrypted code is: %d", fourDigitNumber); 
		
		in.close();
	}

}
