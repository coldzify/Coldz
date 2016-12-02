package Code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;

public class InsertMenu {

	public static void main(String[] args) {
		
			
	
		JFileChooser c = new JFileChooser();
		int option = c.showOpenDialog(null);
		if(option == JFileChooser.APPROVE_OPTION){
			File f = c.getSelectedFile();
			try(BufferedReader b = new BufferedReader(new FileReader(f))){
				AuthenticationController a = new AuthenticationController();
				String s = b.readLine();
		
				/*String[] split = s.split("\\s+");
				System.out.println(split[0]);
				System.out.println(split[1]);*/
				while(s != null){
					System.out.println(s);
					String[] split = s.split("\\s+");
					String name = split[0];
					int cal = Integer.valueOf(split[1]);
					try {
						a.insertMenu(name, cal);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					s = b.readLine();
				}
			}
			catch(IOException e){
				
			}
			catch(SQLException e1){
				
			}
		}
	
		
	}

}
