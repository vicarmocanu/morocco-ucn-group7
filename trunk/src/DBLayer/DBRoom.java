package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Room;
import Model.RoomType;

public class DBRoom implements IFDBRoom {
	private Connection con;
	
	public DBRoom()
	{
		con = DBConnection1.getInstance().getDBcon();
	}

	//Interface methods
	public Room findRoom(int number, boolean retrieveAssociation) {
		return singleWhere("number='"+number+"'",retrieveAssociation);
	}

/*	public ArrayList<Room> findAvailableRooms(int arrival, int departure,
			String type, boolean retrieveAssociation) {
		return miscWhere("(SELECT roomNo FROM RoomLine WHERE booking=(SELECT id FROM RoomBooking WHERE " +
				"arrivalDate>='"+arrival+"' AND departureDate<='"+departure+"'))<>number AND roomType='"+type+"'", retrieveAssociation);
	}*/
	
	public ArrayList<Room> findDifferentRooms(int roomNo,
			boolean retrieveAssociation) {
		ArrayList<Room> rooms = new ArrayList<>();
		
		rooms.addAll(miscWhere("number<>"+roomNo, retrieveAssociation));
		return rooms;
	}
	
	public ArrayList<Room> findAllRooms(boolean retrieveAssociation)
	{
		return miscWhere("", retrieveAssociation);
	}
	//end interface methods
	
	private Room buildRoom(ResultSet result)
	{
		Room roomObj = new Room();
		RoomType roomTypeObj = new RoomType();
		roomObj.setRoomType(roomTypeObj);
		try {
			roomObj.setNumber(result.getInt(1));
			roomTypeObj.setCategory(result.getString(2));
            System.out.println("build Room" + roomObj.getNumber());
		} catch (Exception e) {
			System.out.println("Error in building the Room object!");
		}
		return roomObj;
	}
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT DISTINCT * FROM Room";
		
		if(wClause.length()>0)
		{
			query = query + " WHERE " + wClause;
		}
		
		return query;
	}
	
	private Room singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Room roomObj = new Room();
		String query = buildQuery(wClause);
		System.out.println("DBRoom Query: " + query);
		
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				roomObj = buildRoom(results);
				stmt.close();
				if(retrieveAssociation)
				{//Build RoomType as well
					IFDBRoomType dbRoomType = new DBRoomType();
					RoomType roomTypeObj = dbRoomType.findRoomTypeByCategory(roomObj.getRoomType().getCategory());
					System.out.println("Room type is selected.");
					roomObj.setRoomType(roomTypeObj);
				}
			}
			else
			{
				roomObj = null;
			}
		} catch (Exception e) {
			System.out.println("Query exception - select Room : "+e);
			e.printStackTrace();
		}
		
		return roomObj;
	}
	
	public ArrayList<Room> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<Room> roomList = new ArrayList<Room>();
		String query = buildQuery(wClause);
		System.out.println("DBRoom Query: " + query);
		
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			while (results.next()) {
				Room roomObj = new Room();
				roomObj = buildRoom(results);
				roomList.add(roomObj);
			}
			stmt.close();
			if(retrieveAssociation)
			{//Build RoomType as well
				IFDBRoomType dbRoomType = new DBRoomType();
				for(Room roomObj : roomList)
				{					
					RoomType roomTypeObj = dbRoomType.findRoomTypeByCategory(roomObj.getRoomType().getCategory());
					System.out.println("Room type is selected.");
					roomObj.setRoomType(roomTypeObj);
				}
			}			
		} catch (Exception e) {
			System.out.println("Query exception - select Room : "+e);
			e.printStackTrace();
		}
		
		return roomList;
	}
}
