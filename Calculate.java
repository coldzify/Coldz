package Code;

public class Calculate {
	
	public float getBMI(float height,float weight){
		height = height/100;
		return weight/(height*height);
	}
	public double getBMR(int age,String gender,float height,float weight){
		if(gender.equalsIgnoreCase("Male")){
			return 66+(13.7*weight)+(5*height)-(6.8*age);
		}
		else{
			return 665+(9.6*weight)+(1.8*height)-(4.7*age);
		}
	}
	public int getWalkMinutes(double overCalories){
		return (int) Math.ceil(((60*overCalories)/300));
	}
	public int getRunMinutes(double overCalories){
		return (int) Math.ceil(((60*overCalories)/600));
	}
	public int getSwimMinutes(double overCalories){
		return (int) Math.ceil(((60*overCalories)/400));
	}
	

}