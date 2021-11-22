import java.util.*;
public class Car implements Comparable<Car>{
	int MPG,EngineSize,horsePwr,weight,acc,cyl;
	String country;
	Car car;

public Car(int MPG,int EngineSize,int horsePwr,int weight,int acc,String country,int cyl){

	this.MPG = MPG;
	this.EngineSize = EngineSize;
	this.horsePwr = horsePwr;
	this.weight = weight;
	this.acc = acc;
	this.country = country;
	this.cyl = cyl;
}
public int getMPG(){
	return MPG;
}

public int getEngineSize(){
	return EngineSize;
}
public int gethorsePwr(){
	return horsePwr;
}
public int getWeight(){
	return weight;
}
public int getAcc(){
	return acc;
}
public String getCountry(){
	return country;
}
public int getCyl(){
	return cyl;
}
 public int compareTo(Car obj) {
       return MPG+EngineSize+horsePwr+weight+acc+cyl;
    }
    public String toString()
    {
		//return String.format("%-5s%-5s%-5s%-5s%-5s%-5s%s",MPG+","+EngineSize+","+horsePwr+","+weight+","+acc+","+country+","+cyl);
		return MPG+"\t"+EngineSize+"\t\t"+horsePwr+"\t\t"+weight+"\t\t"+acc+"\t\t"+country+"\t\t"+cyl;
	}

}
