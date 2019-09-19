import java.util.Scanner;

public class Poll {

	static int ROW = 5;
	static int COL = 10;
		
	public static int total(int responses[][], int topicRow) {
		int countScore=0;
			
		for(int c=0; c < COL; c++) {
			countScore += (responses[topicRow][c] * (c+1) );
		}
				
		return countScore;
	}
		
	public static double average(int responses[][], int topicRow) {
		double avg = (double)total(responses, topicRow);
		int count=0;
			
		for(int i=0; i<COL; i++) {
			count += responses[topicRow][i];
		}
			
		avg = avg / count;
			
		return avg;
	}

	public static int mostPoints(int a[][]) {
			
		int max=0;
		int total;
		int maxRow=0;
			
		for(int r = 0; r< ROW; r++) {
			total = total(a, r);
				
			if(total > max) {
				max = total;
				maxRow = r;
			}	
		}
		
		return maxRow;
	}
		
	public static int leastPoints(int a[][]) {
		int min=1000;
		int total;
		int minRow=0;
			
		for(int r = 0; r< ROW; r++) {
			total = total(a, r);
			
			if(total < min) {
				min = total;
				minRow = r;
			}
		}

		return minRow;
	}
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		String[] topic = {"comics", "gaming", "movies", "school", "boxing"};
		int[][] pollResults = new int[ROW][COL];
		int choice;
		int userRating;
			
		int maxRow;
		int minRow;
			
		System.out.println("Press 1 to begin poll\nPress 2 to end poll:");
		choice = in.nextInt();
			
		//Initialize all values in results to 0
		for(int i=0; i < ROW; i++) {
			for(int j = 0; j < COL; j++) {
				pollResults[i][j] = 0;
			}
		}
			
		//prompt user to take poll
		if(choice == 1) {
			
			while(choice == 1) {
				for(int r=0; r < ROW ; r++) {
						
					System.out.println("Rate your opinion on " + topic[r] + " on a scale from 1-10: ");
					userRating = in.nextInt();
					pollResults[r][userRating-1]++;
				}
				
				//prompt user to take poll again
				System.out.println("Press 1 to retake poll\nPress 2 to quit: ");
				choice = in.nextInt();
			}
			
			System.out.printf("       %d %d %d %d %d %d %d %d %d %d\n",1,2,3,4,5,6,7,8,9,10);
				
			for(int r=0; r < ROW ;r++) {
				System.out.print(topic[r]);
					
				for(int c=0; c < COL ; c++) {
					System.out.print(" " + pollResults[r][c]);
				}	
					
				System.out.printf(" average: %.2f\n", average(pollResults, r));
			}
				
			maxRow = mostPoints(pollResults);
			minRow = leastPoints(pollResults);
			System.out.printf("The topic with the most points is %s with %d points total\n", 
						topic[maxRow], total(pollResults, maxRow) );
				
			System.out.printf("The topic with the least points is %s with %d points total\n", 
						topic[minRow], total(pollResults, minRow) );
			
			in.close();
		}
	}
}