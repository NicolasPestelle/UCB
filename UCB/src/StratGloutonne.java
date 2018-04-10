import java.util.ArrayList;

public class StratGloutonne {

	private double nbGain;
	
	
public double rechercheAlea(int nbIteration, ArrayList<Manchot> manchot) {
		
		for(int i =0; i< nbIteration;i++){
			int indiceAuHasard = (int) (Math.random() * (manchot.size() - 1));
			this.nbGain = manchot.get(indiceAuHasard).tirerBras();
		}
		return this.nbGain;
	}

	
}
