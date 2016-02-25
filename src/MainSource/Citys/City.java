package MainSource.Citys;

import MainSource.Client;

public class City {

	protected String name;
	protected Client master=null;
	protected int price;
	protected int fee;
	protected int building=0;
	protected int hotel=0;
	
	public void plusFee(int buildings) {
		// TODO Auto-generated method stub
		fee=fee+5*buildings;
		
	}
	public void setMaster(Client client){
		master=client;
	}
	public Client getMaster(){
		return master;
	}
	public String getName(){
		return name;
	}
	public int getFee(){
		return fee;
	}
	public int getPrice(){
		return price;
	}
	public int getBuilding(){
		return building;
	}
	public int getHotel(){
		return hotel;
	}
	public void setBuilding(int building){
		this.building=this.building+building;
		fee=fee+5*building;
	}
	public void setHotel(int hotel){
		this.hotel=this.hotel+hotel;
		fee=fee+5*hotel;
	}
}