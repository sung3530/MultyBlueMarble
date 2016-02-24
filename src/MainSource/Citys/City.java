package MainSource.Citys;

import MainSource.Client;

public class City {

	protected String name;
	protected Client master;
	protected int price;
	protected int fee;
	protected int building;
	protected int hotel;
	
	public void plusFee(int buildings) {
		// TODO Auto-generated method stub
		fee=fee+5*buildings;
		
	}
}