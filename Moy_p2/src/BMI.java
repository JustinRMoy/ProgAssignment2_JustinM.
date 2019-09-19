import java.util.Scanner;

public class BMI {

	public static void checkBMI(double w, double h) {
		
		double BMI;
		
		BMI = w / h;
		
		System.out.printf("You're BMI is: %.1f\n", BMI);
		
		System.out.println("The BMI Categories:\nUnderweight = <18.5\r\n" + 
				"Normal weight = 18.5–24.9\r\n" + 
				"Overweight = 25–29.9\r\n" + 
				"Obesity = BMI of 30 or greater");	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 1 for BMI in Pounds/Inches\nEnter 2 for BMI in Kilograms/Meters: ");
		int choice = in.nextInt();
		
		double weight;
		double height;
		//double BMI;
		
		if(choice == 1) {// BMI in Pounds
			 
			System.out.println("Enter weight in pounds: ");
			weight = in.nextDouble();
			
			System.out.println("Enter height in inches: ");
			height = in.nextDouble();
			
			weight *= 703;
			height *= height;
			
			checkBMI(weight, height);
			
		}else {	 //BMI in Kilos
			 
			System.out.println("Enter weight in Kilograms: ");
			weight = in.nextDouble();
			System.out.println("Enter height in Meters: ");
			height = in.nextDouble();
			
			height *= height;

			checkBMI(weight, height);
		}
		
		in.close();
	}

}
