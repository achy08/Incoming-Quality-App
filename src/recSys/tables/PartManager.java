package recSys.tables;

import recSys.beans.PartBeans;
import recSys.db.connection.ConnectionManager;
import recSys.interFace.UIInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

//Get Data from Part List

public class PartManager {

	// connect to database

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	private static ObservableList data;

	
	// Show part List to User

	public static void displayPartList(){

		String SQL = "SELECT * from partlist";
		ResultSet rs = null;

		try (Statement stmt = conn.createStatement();){
			rs = stmt.executeQuery(SQL);

			
			while (rs.next()) {
                ObservableList row = FXCollections.observableArrayList();

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);

			}
			UIInterface.table.setItems(data);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// method to get part information from part list

	public static PartBeans getPartInfo(String partNum){
		//SQL Statement

		String SQL = "SELECT * from partlist WHERE partNumber = ?";
		ResultSet rs = null;

		try(
				PreparedStatement stmt = conn.prepareStatement(SQL);
				)
		{

			stmt.setString(1, partNum);
			rs = stmt.executeQuery();

			if(rs.next())
			{
				PartBeans bean = new PartBeans();
				bean.setNumber(rs.getString("partNumber"));
				bean.setName(rs.getString("partName"));
				bean.setProject(rs.getString("project"));
				bean.setInspectionLevel(rs.getInt("inspectionLevel"));
				return bean;

			}

			else{
				return null;
			}

		} catch (SQLException e) {

			System.err.println(e.toString());
			return null;

		}
	}

	public static void TightenLevel (String partNum)
	{
		String SQL = "UPDATE `partlist` SET `inspectionLevel`= `inspectionLevel`+1 WHERE partNumber = ?";
		String SQL2 = "SELECT `inspectionLevel` FROM `partlist` WHERE partNumber = ?";
		
			try (PreparedStatement stmt = conn.prepareStatement(SQL);
					PreparedStatement s = conn.prepareStatement(SQL2);)
			{

				stmt.setString(1, partNum);
				stmt.executeUpdate();
				s.setString(1, partNum);
				ResultSet rs = s.executeQuery();
				if(rs.next())
				{
				System.out.println("Inspection Level Increased To: " + rs.getInt("inspectionLevel"));
				}
				
				else
				{
					System.err.println("Nothing Changed");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static void ReduceLevel(String partNum)
	{

		String SQL = "UPDATE `partlist` SET `inspectionLevel`= `inspectionLevel`-1 WHERE partNumber = ?";
		String SQL2 = "SELECT * FROM `inspectionlogsheet` WHERE partNumber = ?";

			
			try(CallableStatement stmt = conn.prepareCall(SQL);
					PreparedStatement s = conn.prepareStatement(SQL2);)
			{
				
				stmt.setString(1, partNum);
				stmt.executeUpdate();
				s.setString(1, partNum);
				ResultSet rs = s.executeQuery();

				if (rs.next())
				{
					System.out.println("Inspection Level Reduced To: " + rs.getInt("inspectionLevel"));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
}
