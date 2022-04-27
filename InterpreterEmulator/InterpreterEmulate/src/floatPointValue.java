import java.lang.Math;
import java.util.Scanner;
public class floatPointValue {
	
	public void emulator() {
		
		
		System.out.println("Brandon Chao Emulator V2");
		System.out.println("Type 'exit' to terminate");
		
		Scanner scan = new Scanner(System.in);
		String s = "";
		System.out.print(">>> ");
		s = scan.next();
		while(!s.equals("exit")) {
			validate(s);
			System.out.print(">>>");
			s = scan.next();
		}
		scan.close();
	}
	
	
	public void validate(String x) {
		if(isValid(x)) {
			System.out.println(valueOf(x));
		}
		else
			System.out.println("ERROR: '" + x + "' is not a valid value");
	}
	
	public boolean isValid(String x)
	{
		int size = x.length();
		int state = 1;
		
		char letter;
		int asciiValue;
		
		for(int i = 0; i < size; i++) {
			letter = x.charAt(i);
			asciiValue = (int) letter;
			
			switch(state) {
				case 1:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 2;
					}
					else if( asciiValue == 46 )
					{
						state = 3;
					}
					else
						return false;
					break;
				case 2:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 2;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else if( asciiValue == 46 )
					{
						state = 7;
					}
					else if(asciiValue == 95) {
						state = 4;
					}
					else if(asciiValue == 69 || asciiValue == 101) {
						state = 9;
					}
					else
						return false;
					break;
				case 3:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
					}
					else
						return false;
					break;
				case 4:
					if(asciiValue == 95) {
						state = 4;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 2;
					}
					else
						return false;
					break;
				case 5:
					if(i != size - 1) {
						return false;
					}
					break;
				case 6:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
					}
					else if(asciiValue == 95) {
						state = 8;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else if(asciiValue == 69 || asciiValue == 101) {
						state = 13;
					}
					else
						return false;
					break;
				case 7:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
					}
					else if(asciiValue == 69 || asciiValue == 101) {
						state = 13;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else
						return false;
					break;
				case 8:
					if(asciiValue == 95) {
						state = 8;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
					}
					else
						return false;
					break;
				case 9:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
					}
					else if(asciiValue == 43 || asciiValue == 45) {
						state = 10;
					}
					else
						return false;
					break;
				case 10:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
					}
					else
						return false;
					break;
				case 11:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
					}
					if(asciiValue == 95) {
						state = 12;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else
						return false;
					break;
				case 12:
					if(asciiValue == 95) {
						state = 12;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
					}
					else
						return false;
					break;
				case 13:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
					}
					else if(asciiValue == 43 || asciiValue == 45) {
						state = 14;
					}
					else
						return false;
					break;
				case 14:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
					}
					else
						return false;
					break;
				case 15:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else if(asciiValue == 95) {
						state = 16;
					}
					else
						return false;
					break;
				case 16:
					if(asciiValue == 95) {
						state = 16;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
							state = 15;
					}
					else
						return false;
					break;
			}
		}
		
		return true;
	}
	
	public float valueOf(String x) {
		float result = 1;
		
		return result;
	}
	
	public static void main(String[] args) {
		floatPointValue machine = new floatPointValue();
		machine.emulator();
	}
}

