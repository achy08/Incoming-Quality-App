package recSys.sampleSizeUtil;

public class CodeAssignment {
	private static String codeAssigned;

//Assign Code for Reduced Inspection Level	
public static String assigncode1(int lotSize){
		
				
		if (lotSize >= 2 && lotSize<= 170){
			codeAssigned = "A";
		}
		if (lotSize >= 171 && lotSize<= 288){
			codeAssigned = "A";
		}
		if (lotSize >= 289 && lotSize<= 544){
			codeAssigned = "A";
		}
		if (lotSize >= 545 && lotSize<= 960){
			codeAssigned = "B";
		}
		if (lotSize >= 961 && lotSize<= 1632){
			codeAssigned = "C";
		}
		if (lotSize >= 1633 && lotSize<= 3072){
			codeAssigned = "D";
		}
		if (lotSize >= 3073 && lotSize<= 5440){
			codeAssigned = "E";
		}
		if (lotSize >= 5441 && lotSize<= 9216){
			codeAssigned = "E";
		}
		if (lotSize >= 9217 && lotSize<= 17408){
			codeAssigned = "E";
		}
		if (lotSize >= 17409 && lotSize<= 30720){
			codeAssigned = "E";
		}
		if (lotSize >= 30721){
			codeAssigned = "E";
		}
		
		
		return codeAssigned;
		
	}

//Assign Code for Normal Inspection Level
public static String assigncode2(int lotSize){
		
		
		if (lotSize >= 2 && lotSize<= 170){
			codeAssigned = "A";
		}
		if (lotSize >= 171 && lotSize<= 288){
			codeAssigned = "A";
		}
		if (lotSize >= 289 && lotSize<= 544){
			codeAssigned = "B";
		}
		if (lotSize >= 545 && lotSize<= 960){
			codeAssigned = "C";
		}
		if (lotSize >= 961 && lotSize<= 1632){
			codeAssigned = "D";
		}
		if (lotSize >= 1633 && lotSize<= 3072){
			codeAssigned = "E";
		}
		if (lotSize >= 3073 && lotSize<= 5440){
			codeAssigned = "E";
		}
		if (lotSize >= 5441 && lotSize<= 9216){
			codeAssigned = "E";
		}
		if (lotSize >= 9217 && lotSize<= 17408){
			codeAssigned = "E";
		}
		if (lotSize >= 17409 && lotSize<= 30720){
			codeAssigned = "E";
		}
		if (lotSize >= 30721){
			codeAssigned = "E";
		}
		
		
		return codeAssigned;
		
	}

//Assign Code for Tightened Inspection Level
	public static String assigncode3(int lotSize){
		
		
		if (lotSize >= 2 && lotSize<= 170){
			codeAssigned = "A";
		}
		if (lotSize >= 171 && lotSize<= 288){
			codeAssigned = "B";
		}
		if (lotSize >= 289 && lotSize<= 544){
			codeAssigned = "C";
		}
		if (lotSize >= 545 && lotSize<= 960){
			codeAssigned = "D";
		}
		if (lotSize >= 961 && lotSize<= 1632){
			codeAssigned = "E";
		}
		if (lotSize >= 1633 && lotSize<= 3072){
			codeAssigned = "E";
		}
		if (lotSize >= 3073 && lotSize<= 5440){
			codeAssigned = "E";
		}
		if (lotSize >= 5441 && lotSize<= 9216){
			codeAssigned = "E";
		}
		if (lotSize >= 9217 && lotSize<= 17408){
			codeAssigned = "E";
		}
		if (lotSize >= 17409 && lotSize<= 30720){
			codeAssigned = "E";
		}
		if (lotSize >= 30721){
			codeAssigned = "E";
		}
		
		
		return codeAssigned;
		
	}
}