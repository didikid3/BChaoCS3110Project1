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
		double value = isValid(x);
		if(value != -1) {
			System.out.println(value);
		}
		else
			System.out.println("ERROR: '" + x + "' is not a valid value");
	}
	
	public double isValid(String x)
	{
		int size = x.length();
		int state = 1;
		
		char letter;
		int asciiValue;
		
		double value = 0.0;
		int decimal = 0;
		
		int exponent = 0;
		boolean exponentSign = false;
		
		for(int i = 0; i < size; i++) {
			letter = x.charAt(i);
			asciiValue = (int) letter;
			
			switch(state) {
				case 1:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 2;
						
						value = (value*10) + (asciiValue-48);
					}
					else if( asciiValue == 46 )
					{
						state = 3;
					}
					else
						return -1;
					break;
				case 2:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 2;
						
						value = (value*10) + (asciiValue-48);
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
						return -1;
					break;
				case 3:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
						
						value = (value*10) + (asciiValue-48);
						decimal += 1;
					}
					else
						return -1;
					break;
				case 4:
					if(asciiValue == 95) {
						state = 4;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 2;
						
						value = (value*10) + (asciiValue-48);
					}
					else
						return -1;
					break;
				case 5:
					if(i != size - 1) {
						return -1;
					}
					break;
				case 6:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
						
						value = (value*10) + (asciiValue-48);
						decimal += 1;
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
						return -1;
					break;
				case 7:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
						
						value = (value*10) + (asciiValue-48);
						decimal += 1;
					}
					else if(asciiValue == 69 || asciiValue == 101) {
						state = 13;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else
						return -1;
					break;
				case 8:
					if(asciiValue == 95) {
						state = 8;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 6;
						
						value = (value*10) + (asciiValue-48);
						decimal += 1;
					}
					else
						return -1;
					break;
				case 9:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					else if(asciiValue == 43 || asciiValue == 45) {
						state = 10;
						
						if(asciiValue == 45) {
							exponentSign = true;
						}
					}
					else
						return -1;
					break;
				case 10:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					else
						return -1;
					break;
				case 11:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					if(asciiValue == 95) {
						state = 12;
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else
						return -1;
					break;
				case 12:
					if(asciiValue == 95) {
						state = 12;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 11;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					else
						return -1;
					break;
				case 13:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					else if(asciiValue == 43 || asciiValue == 45) {
						state = 14;
						
						if(asciiValue == 45) {
							exponentSign = true;
						}
					}
					else
						return -1;
					break;
				case 14:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					else
						return -1;
					break;
				case 15:
					if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
						
						exponent = (exponent*10) + (asciiValue-48);
					}
					else if(asciiValue == 68 || asciiValue == 70 ||
							asciiValue == 100 || asciiValue == 102) {
						state = 5;
					}
					else if(asciiValue == 95) {
						state = 16;
					}
					else
						return -1;
					break;
				case 16:
					if(asciiValue == 95) {
						state = 16;
					}
					else if(asciiValue >= 48 && asciiValue <= 57) {
						state = 15;
							
						exponent = (exponent*10) + (asciiValue-48);
					}
					else
						return -1;
					break;
			}
		}
		if(		state == 1 ||
				state == 2 || 
				state == 3 || state == 4 ||
				state == 8 || state == 9 ||
				state == 10 || state == 12 ||
				state == 13 || state == 14 ||
				state == 16
		) {
			return -1;
		}
		
		value = value * Math.pow(10, -1* decimal);
		if(exponentSign)
			value = value * Math.pow(10,-1* exponent);
		else
			value = value * Math.pow(10, exponent);
		
		return value;
	}
	
	
	public static void main(String[] args) {
		floatPointValue machine = new floatPointValue();
		machine.emulator();
	}
}


