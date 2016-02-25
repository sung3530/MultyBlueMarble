package MainSource.Citys;

import MainSource.Client;

public class CityCheck {
	
	public static CityCheck cityCheck=new CityCheck();
	public static CityCheck getInstance(){
		return cityCheck;
	}
	
	private CityList cityList=new CityList();
	

	
	public CityList getCityList(){
		return cityList;
	}
	public boolean checkIsland(int position){
		if(cityList.getCityList()[position].getName()==cityList.getCityList()[4].getName()){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean checkSpaceTravel(int position){
		if(cityList.getCityList()[position].getName()==cityList.getCityList()[12].getName()){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean checkName(int position,String name){
		if(cityList.getCityList()[position].getName()==name){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean checkCity(int position){	
		if(cityList.getCityList()[position].getMaster()==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int fee_price(int position,Client client){
		if(cityList.getCityList()[position].getMaster()==null){
			return cityList.getCityList()[position].getPrice();
		}
		else if(cityList.getCityList()[position].getMaster()==client){
			return 0;
		}
		else{
			return cityList.getCityList()[position].getFee();
		}
	}
}
