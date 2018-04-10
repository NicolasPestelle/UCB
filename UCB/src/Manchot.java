import java.util.ArrayList;
import java.util.Random;

public class Manchot {
	private double variance;
	private double esperance;
	private ArrayList<Manchot> manchot = new ArrayList<Manchot>();
	
	
	public Manchot(double variance, double esperance) {
		this.esperance = esperance;
		this.variance = variance;
	}
	
	
	
	
	public double tirerBras(){
		double rand1 = Math.random();
		double rand2 = Math.random();
		return variance * Math.sqrt(-2.0* Math.log(rand1))*Math.cos(2*Math.PI*rand2)+esperance;
	}
}
