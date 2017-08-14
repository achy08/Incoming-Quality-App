package recSys.sampleSizeUtil;

public class CodeGeneration {
	
	public static String CodeGenerator (int InspectionLevel, int lotSize)
	{
		
	String code = null;
	if (InspectionLevel  == 1)
	{
		code = CodeAssignment.assigncode1(lotSize);
	}
	if (InspectionLevel  == 2)
	{
		code = CodeAssignment.assigncode2(lotSize);
	}
	if (InspectionLevel  == 3)
	{
		code = CodeAssignment.assigncode3(lotSize);
	}
	
	return code;

	}
}
