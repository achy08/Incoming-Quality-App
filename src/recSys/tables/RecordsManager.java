package recSys.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import recSys.beans.AQLBeans;
import recSys.beans.PartBeans;
import recSys.db.connection.ConnectionManager;
import recSys.sampleSizeUtil.CodeGeneration;

//Create Record in Log Sheet

public class RecordsManager {

	//connect to database	
	private static Connection conn = ConnectionManager.getInstance().getConnection();

	// variables

	private static  PartBeans part = new PartBeans();
	private static AQLBeans aql = new AQLBeans();
	
	
	

	// insert into Records Table method

	public static void insertRecord(String partNum, String lotNum, int lotSize, String status) throws Exception{

		// SQL Insert Statement

		String sql = "INSERT into `inspectionlogsheet`" + 
				"(`partNumber`,`partName`, `project`,`lotNumber`,`lotSize`, `inspectionLevel` , `sampleSize`,`statusIsNG`)" + 
				 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		part = PartManager.getPartInfo(partNum);
		
		//Assign Inspection Code based on Inspection Level and Lot size
		String code = CodeGeneration.CodeGenerator(part.getInspectionLevel(), lotSize);	

		//Generate Sample Size
		aql = AQLManager.setSampleSize(part.getInspectionLevel(), code);		
		
		//Add Record
		try (PreparedStatement stmt = conn.prepareStatement(sql);
				)
		{

			
			stmt.setString(1, part.getNumber());
			stmt.setString(2, part.getName());
			stmt.setString(3, part.getProject());
			stmt.setString(4, lotNum);
			stmt.setInt(5, lotSize);
			stmt.setInt(6, part.getInspectionLevel());
			stmt.setInt(7, aql.getSampleSize());
			stmt.setBoolean(8, aql.isNG());

			
	
			
			//Record Summary before Insert
			

			System.out.println("=================================");
			System.out.println("        Record Summary           ");
			System.out.println("=================================");
			System.out.println("Part Number: " + part.getNumber());
			System.out.println("Part Name: " + part.getName());
			System.out.println("Inspection Level: " + part.getInspectionLevel());
			System.out.println("Lot Number: " + lotNum);
			System.out.println("Lot Size: " + lotSize);
			System.out.println("Sample Size: " + aql.getSampleSize());
			System.out.println("Lot Status: " + status);
			System.out.println("=================================");
			
			//Print Confirmation
			int affected = stmt.executeUpdate();			
			if (affected == 1){

				System.out.println("Record added");
				System.out.println("=============");
			}
			else{
				System.out.println("Nothing added");
				System.out.println("=============");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());
		}
		
//		finally{
//			ConnectionManager.getInstance().close();
//		}


	}


//	public static ArrayList<RecordBeans> getRecord(){
//
//		String sql = "SELECT * FROM inspectionlogsheet";
//
//		try(
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);)
//		{
//
//			while (rs.next()){
//
//				record.setPartNumber(rs.getString("partNumber"));
//				record.setLotNumber(rs.getString("lotNumber"));
//				record.setInspectionLevel(rs.getInt("inspectionLevel"));
//				result.add(record);				
//			}
//			return result;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.err.println(e.toString());
//			return null;
//		}
//	}

}	


