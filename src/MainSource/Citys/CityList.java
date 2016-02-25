package MainSource.Citys;

public class CityList {
	private City[] cityList=new City[16];
	
	public CityList(){
		setCityList();
		
	}
	public City[] getCityList(){
		return cityList;
	}
	private void setCityList(){
		cityList[0]=new Start_Point();
		cityList[1]=new Beijing();
		cityList[2]=new HongKong();
		cityList[3]=new Incheon();
		cityList[4]=new Island();
		cityList[5]=new Kiev();
		cityList[6]=new London();
		cityList[7]=new LosAngeles();
		cityList[8]=new Moskva();
		cityList[9]=new NewYork();
		cityList[10]=new Paris();
		cityList[11]=new Seoul();
		cityList[12]=new Space_Travel();
		cityList[13]=new Stockholm();
		cityList[14]=new Sydey();
		cityList[15]=new Tokyo();																							
	}
}
