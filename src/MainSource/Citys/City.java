package MainSource.Citys;

import MainSource.Client;

public class City {

	String name;
	Client master;
	int price;
	int fee;
	int building;
	int hotel;
	
	public void plusFee(int buildings) {
		// TODO Auto-generated method stub
		fee=fee+5*buildings;
		
	}
}