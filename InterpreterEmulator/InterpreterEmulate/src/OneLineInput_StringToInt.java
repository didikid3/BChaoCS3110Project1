import java.lang.Math;
import java.util.Scanner;
public class OneLineInput_StringToInt {

	
	//Continuous Loop For User
	public static void emulator() {
		OneLineInput_StringToInt machine = new OneLineInput_StringToInt();
		
		System.out.println("Brandon Chao Number Reader");
		System.out.println("Type 'exit' to terminate");
		Scanner scan = new Scanner(System.in);
		String s = "";
		System.out.print(">>>");
		s = scan.next();
		while(!s.equals("exit")) {
			machine.isValid(s);
			System.out.print(">>>");
			s = scan.next();
		}
		scan.close();
	}
	
	
	//Wrapper Function for Validate String
	public void isValid(String x) {
		if(validateString(x)) {
			validValue(stringValue(x));
		}
		else {
			invalidValue(x);
		}
	}
	
	/** Confirm Valid Input 
	*<p> 
	*At most 1 Decimal Point
	*At most 1 (E/e)
	*At most 1 sign(+/-)
	*<p>
	*If decimal, must occur before (E/e)
	*If(E/e), must be followed by integer
	*If (+/-), must occur at first index
	*<p>
	*Must only consist of decimal points, (E/e), (+/-), [0-9]
	*<p>
	*@param x the input from terminal
	*@return boolean describing whether a string is a mathematical value
	*/
	public boolean validateString(String x) {
		boolean valid = true;
		boolean includesDecimal = false;
		boolean includesExponent = false;
		
		int stringLength = x.length();
		char letter;
		int asciiValue = 0;
		for (int i = 0; i < stringLength; i++) {
			letter = x.charAt(i);
			asciiValue = (int) letter;
			
			
			switch(asciiValue) {

			//If (+/-), must occur at first index
			case 43:
			case 45:
				if(i!= 0)
					return false;
				break;
			
			
			//At most 1 Decimal Point
			//If decimal, must occur before (E/e)
			case 46:
				if(includesExponent || includesDecimal)
					return false;
				includesDecimal = true;
				break;
				
				
			//At most 1 (E/e)
			//If(E/e), must be followed by integer
			case 69:
			case 101:
				if(includesExponent)
					return false;
				else {
					if(i == stringLength-1)
						return false;
					includesExponent = true;
					break;
				}
				
			//Must only consist of decimal points, (E/e), (+/-), [0-9]
			case 48:
			case 49:
			case 50:
			case 51:
			case 52:
			case 53:
			case 54:
			case 55:
			case 56:
			case 57:
				break;
			
			default:
				return false;
			}//END SWITCH
		}//END FOR
		
		return valid;
	}//END VALIDATE STRING
	
	//Convert String to Value
	//Assumes String is a valid input
	public double stringValue(String x) {
		double result = 0.0;
		int sign = 1;
		
		int length = x.length();
		char letter;
		int asciiValue = 0;
		
		boolean decimalPlaced = false;
		int decimalPosition = 1;
		
		int exponentValue = 0;
		boolean exponent = false;
		for(int i = 0; i<length; i++){
			letter = x.charAt(i);
			asciiValue = (int) letter;
			
			//Check if value is negative or positive
			if(i == 0) {
				if(asciiValue == 45)
					sign = -1;
			}
			if(!exponent) {
				//46 (.)
				if(asciiValue == 46)
					decimalPlaced = true;
			
				//48 - 57 (0-9)
				if(48 <= asciiValue && asciiValue <= 57) {
					if(!decimalPlaced) {
						result = (result*10) + (asciiValue - 48);
					}
					else {
						result = result + (asciiValue-48)/(Math.pow(10, decimalPosition));
						decimalPosition++;
					}
				}
				
				//69 & 101 (E & e)
				if(asciiValue == 69 || asciiValue == 101)
					exponent = true;
				
			}
			//Everything after E should be separate from actual value
			else {
				exponentValue = (exponentValue * 10) + (asciiValue - 48);
			}
				

		}//END FOR LOOP
		
		result = sign * result * (Math.pow(10, exponentValue));
		
		return result;
	}//END STRING TO VALUE
	
	//Display Result
	public void validValue(double x) {
		System.out.println(x);
	}
	
	//Not Valid Input Result
	public void invalidValue(String x) {
		System.out.println("ERROR: '" + x + "' is not a valid value");
	}
	
	public void runTestCases() {
		isValid("4.25.3");
		isValid("3e5.2");
		isValid("--2");
		isValid("3a52");
		isValid("-2");
		isValid("342e2");
		isValid("3.42E5");
	}
	
	public static void main(String[] args) {

		//OneLineInput_StringToInt machine = new OneLineInput_StringToInt();
		
		OneLineInput_StringToInt.emulator();

	}
}
