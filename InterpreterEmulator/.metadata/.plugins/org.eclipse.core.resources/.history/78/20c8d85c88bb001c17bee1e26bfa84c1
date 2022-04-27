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
			System.out.println((stringValue(x)));
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
		
		boolean exponentIsLast = false;
		
		int stringLength = x.length();
		char letter;
		int asciiValue = 0;
		for (int i = 0; i < stringLength; i++) {
			letter = x.charAt(i);
			asciiValue = (int) letter;
			
			
			switch(asciiValue) {

			//If (+/-), must occur at first index
			//Or occur immediately after (E/e)
			case 43:
			case 45:
				if(includesExponent) {
					if(exponentIsLast) {
						exponentIsLast = false;
					}
					else
					{
						return false;
					}
				}
				//May Need to change if values must be unary
				//IE NO NEGATIVE IN FRONT
				else if(i!= 0)
					return false;
					
				break;
			
			
			//At most 1 Decimal Point
			//If decimal, must occur before (E/e)
			case 46:
				if(includesExponent && exponentIsLast) {
					exponentIsLast = false;
				}
				
				if(includesExponent || includesDecimal)
					return false;
				includesDecimal = true;
				break;
				
			case 68:	
			case 70:
			case 100:
			case 102:
				if(i != stringLength - 1)
					return false;
				break;
				
			//At most 1 (E/e)
			//If(E/e), must be followed by integer
			case 69:
			case 101:
				
				if(includesExponent)
					return false;
				else {
					includesExponent = true;
					exponentIsLast = true;
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
				if(includesExponent && exponentIsLast) {
					exponentIsLast = false;
				}
				
				break;
			
			//Underscore
			case 95:
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
		
		double exponentValue = 0;
		int exponentSignValue = 1;
		boolean exponentSign = false;
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
					if(!exponentSign) {
						if(asciiValue == 43 || asciiValue == 45) {
							if (asciiValue == 45) {
								exponentSign = true;
								exponentSignValue = -1;
							}
							else
								exponentSign = true;
						}
						else {
							if(asciiValue != 70 && asciiValue != 102 && 
									asciiValue != 68 && asciiValue != 100
									&& asciiValue != 95) {
								exponentValue = (exponentValue * 10) + (asciiValue - 48);
							}
						}
					}
					else {
						if(asciiValue != 70 && asciiValue != 102 && 
								asciiValue != 68 && asciiValue != 100
								&& asciiValue != 95)
						{
							exponentValue = (exponentValue * 10) + (asciiValue - 48);
						}
					}
			}
				

		}//END FOR LOOP
		exponentValue = exponentSignValue * exponentValue;
		exponentValue = Math.pow(10, exponentValue);
		result = sign*result*exponentValue;
		
		result = result * Math.pow(10, length);
		result = Math.round(result);
		result = result / Math.pow(10, length);
		

		
		return result;
	}//END STRING TO VALUE
	
	//Display Result
	public double validValue(double x) {
		return x;
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
		isValid("52_1235");
		isValid("47.2_1");
		isValid("4_2e-5");
	}
	
	/*
	public void evaluateExpression(String x)
	{
		if(validExpression(x))
			expressionValue(x);
		else
			invalidValue(x);
	}
	
	public boolean validExpression(String x) {
		boolean validExpression = true;
		int stringLength = x.length();
		
		for(int i = 0; i < stringLength; i++) {
			
		}
		
		return validExpression;
	}
	*/
	public static void main(String[] args) {
		//OneLineInput_StringToInt machine = new OneLineInput_StringToInt();
		//machine.runTestCases();
		OneLineInput_StringToInt.emulator();
	}
}
