package recSys.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import recSys.beans.AQLBeans;
import recSys.db.connection.ConnectionManager;

public class AQLManager {

	private static Connection conn = ConnectionManager.getInstance().getConnection();
	private static AQLBeans bean = new AQLBeans();


	public static AQLBeans setSampleSize(int InspectionLevel, String code){


		String sql1 = "SELECT * from SSR WHERE assignedCode = ?";
		String sql2 = "SELECT * from SSN WHERE assignedCode = ?";
		String sql3 = "SELECT * from SST WHERE assignedCode = ?";

		if (InspectionLevel == 1){

			try(PreparedStatement stmt = conn.prepareStatement(sql1);)
			{
				stmt.setString(1, code);
				ResultSet rs = stmt.executeQuery();
				while (rs.next())
				{
					bean.setSampleSize(rs.getInt("sampleSize"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (InspectionLevel == 2){

			try(PreparedStatement stmt = conn.prepareStatement(sql2);)
			{
				stmt.setString(1, code);
				ResultSet rs = stmt.executeQuery();
				while (rs.next())
				{
					bean.setSampleSize(rs.getInt("sampleSize"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (InspectionLevel == 3){

			try(PreparedStatement stmt = conn.prepareStatement(sql3);)
			{
				stmt.setString(1, code);
				ResultSet rs = stmt.executeQuery();
				while (rs.next())
				{
					bean.setSampleSize(rs.getInt("sampleSize"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bean;

	}



	public static void setAQL(String partNum, boolean lotNG, int currentLevel){
		String SQLNG = "SELECT COUNT(*) FROM" +
				"(SELECT * FROM `inspectionlogsheet`  ORDER BY lotNumber DESC LIMIT 5)"+ 
				"AS marker WHERE marker.partNumber = ? AND marker.statusIsNG = 1";
		
		String SQLOK = "SELECT COUNT(*) FROM" + 
				"(SELECT * FROM `inspectionlogSheet` ORDER BY lotNumber DESC LIMIT 10)" +
				"AS marker WHERE marker.partNumber = ? AND marker.statusIsNG = 0";
		
		ResultSet rs = null;
		
		
		if (lotNG == true)
		{
			try (PreparedStatement stmt = conn.prepareStatement(SQLNG);
				 )
			{
				stmt.setString(1, partNum);
				rs = stmt.executeQuery();
				while (rs.next())
				{				
					bean.setCountNG(rs.getInt("Count(*)"));
				}
				
				if ((bean.getCountNG()%2) == 0 && currentLevel < 3)
				{
					PartManager.TightenLevel(partNum);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			
			try (PreparedStatement stmt = conn.prepareStatement(SQLOK))
			{
				stmt.setString(1, partNum);
				rs = stmt.executeQuery();
				
				while (rs.next()){
					
					bean.setCountOK(rs.getInt("Count(*)"));
				}
				
				if (bean.getCountOK() == 10 && currentLevel > 1)			
				{
					PartManager.ReduceLevel(partNum);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}

