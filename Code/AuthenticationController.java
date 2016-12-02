package Code;


import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class AuthenticationController  {
	public DBConnection con;
	
	public AuthenticationController() throws SQLException{
		con = new DBConnection("postgres","1234","jdbc:postgresql://localhost:5432/reckon");
		if(!con.openConnection())
			throw new SQLException("Cannot connect database server.");
	}
	
	public boolean login(String userName, String password) throws Exception {
		String sqlCommand = "SELECT username, password ,age FROM useraccounts where username = "+"'"+userName+"'"+"and password = "+"'"+password+"'"+";";
		ResultSet result = con.executeQueryStatement(sqlCommand);
			if (result.next()) {
				return true;
				
			} else {
				return false;
			}

		
	}
	public boolean insert(String user,String password,String gender,int age,int weight,int height) throws SQLException{
		String sqlCommand = "INSERT INTO public.useraccounts(username, password, gender, age, weight, height)VALUES ("+"'"+user+"'"+","+"'"+password+"'"+","+"'"+gender+"'"+","+age+","+weight +","+height+");";
		
		if(con.executeInsertUpdateStatement(sqlCommand)){
			return true;
		}
		else return false;
		

	}
	public void close(){
		con.closeConnection();
	}
	public String[] getInfo(String user) throws Exception{
		String[] info = new String[4];
		String sqlCommand = "SELECT gender,age,weight,height FROM useraccounts where username = "+"'"+user+"'"+";";
		ResultSet result = con.executeQueryStatement(sqlCommand);
		if (result.next()) {
			
			for(int i = 0 ; i < info.length ; i++){
				info[i] = result.getString(i+1);
			}
		}
		return info;
	}
	public boolean insertMenu(String name,int cal) throws Exception{
		String sqlCommand = "INSERT INTO public.menulist(name, calories)VALUES ("+"'"+name+"'"+","+cal+");";
		if(con.executeInsertUpdateStatement(sqlCommand)){
			return true;
		}
		else return false;
	}
	public String[][] getMenu() throws Exception{
		String[][] info = new String[500][2];
		String sqlCommand = "SELECT * FROM public.menulist ORDER BY name ASC ";
		ResultSet result = con.executeQueryStatement(sqlCommand);
		int i = 0;
		while (result.next()) {
				for(int j = 0 ; j < 2 ; j++){
					info[i][j] = result.getString(j+1);
				}
			i++;
		}
		
		return info;
	}
	public String[][] searchMenuList(String name) throws Exception{
		String[][] info = new String[500][2];
		String sqlCommand = "SELECT * FROM public.menulist WHERE name LIKE '%"+name+"%'";
		ResultSet result = con.executeQueryStatement(sqlCommand);
		int i = 0;
		while(result.next()){
			for(int j = 0 ; j < 2 ; j++){
				//System.out.println(result.getString(1));
				info[i][j] = result.getString(j+1);
			}
			i++;
		}
		return info;
	}
	public boolean update(String user,String gender,int age,int weight,int height) throws SQLException{
		String sqlCommand = "UPDATE public.useraccounts SET gender = '"+gender+"', age = '"+age+"', weight = '"+weight+"', height = '"+height+"' WHERE username = '"+user+"';";
			con.executeInsertUpdateStatement(sqlCommand);

		return true;
	}
	
	public static void main(String[] aa){
		try {
			AuthenticationController a  = new AuthenticationController();
			a.update("1111", "MALE", 1, 2, 3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
