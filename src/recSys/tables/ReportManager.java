package recSys.tables;
import java.sql.*;
import java.util.Scanner;

import recSys.db.connection.ConnectionManager;

public class ReportManager {

	private static Connection conn = ConnectionManager.getInstance().getConnection();
	private static String sql;
	private static Scanner in;
	private static String SQL(SQLType sqlType){
		
		try{
			switch(sqlType){
			case byDate :
				
				sql= "SELECT * from inspectionlogsheet WHERE date BETWEEN ? AND ?";
				return sql;
			
			case byPart:
				
				sql = "SELECT * from inspectionlogsheet WHERE partNumber = ?";
				return sql;
						
			default:
				return null;
				
			}
		}
		catch (Exception e){
			
			System.out.println("Wrong input");
			return null;
		}
	}
	public static ResultSet executeSQL(String reportType) throws SQLException{
		//variables
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = null;

		if (reportType.contains("d"))
		{
		//Generate SQL Result by Date	
			sql = SQL(SQLType.byDate);
			rs = stmt.executeQuery();
		}
		
		if (reportType.contains("p"))
		{
		//Generate SQL Result by Part Number	
			sql = SQL(SQLType.byPart);
			rs = stmt.executeQuery();		
		}
		
		return rs;
			
		}
	
	public static void genReport(){
		in = new Scanner(System.in);

//		ReportBeans rep = new ReportBeans();
//		ArrayList<ReportBeans> report = new ArrayList<ReportBeans>();
		
		
		//What type of report is required? 
		System.out.println("What Type of Report is Required? (By Date or By Part Number): ");
		String reportType = in.next();
		//Execute SQL
		try (ResultSet record = executeSQL(reportType);){
			
//			display report
			while (record.next()){	
				
				System.out.println(record.toString());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	

		
		
		
		
	}
	

