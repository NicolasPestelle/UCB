import java.util.ArrayList;

public class StratGloutonne {

	private double nbGain;
	
	
public double rechercheGloutonne(int nbIteration, ArrayList<Manchot> manchot) {
		int indiceBestBra = 0;
		for(int i =0; i< manchot.size();i++){
			int bestBra = 0;
			if (manchot.get(i).tirerBras() > bestBra){
				bestBra =i;
			}
			
			indiceBestBra = bestBra;
		}
		
		for(int j = 0; j<nbIteration;j++){
			this.nbGain += manchot.get(indiceBestBra).tirerBras();
		}
		
		return this.nbGain;
	}

	
}
