import java.util.ArrayList;

public class StratUcb {
	
	private double nbGain;
	private ArrayList<Integer> nbTirage = new ArrayList<Integer>() ;
	private ArrayList<Double> score= new ArrayList<Double>();
	private ArrayList<Double> ucb= new ArrayList<Double>();
	
	private int nbTirageTT ; 
	
	//tableau ucb pour chaque bras

	
	public double rechercheUcb(int nbIteration, ArrayList<Manchot> manchot, int k) {
		
		
		//initialisation des tableaux
		
		for(int l = 0; l<manchot.size();l++){
			nbTirage.add(l, 0);
			score.add(l, 0.0);
			ucb.add(l, 0.0);
		}
		
		//initialisation des valeurs
		
		for(int i =0; i< manchot.size();i++){
			//nbTirage.add(i, nbTirage.get(i)+1);
			nbTirage.set(i, +1);
			
			double scor = manchot.get(i).tirerBras();
			
			score.set(i, scor);
			
			nbGain += scor;
			
		}
		
		
		
		
		
		//algo principal
		
		for(int j =0; j< nbIteration - manchot.size();j++){
			
			//on prend le plus gros score ucb et on ajoute les gains et on recommence a chaque itération
			int r =calculUcb(manchot,k);	
			
			double gain;
			
			gain= manchot.get(r).tirerBras();
			
			int iter = nbTirage.get(r);
			nbTirage.set(r, iter+1);
			
			nbGain += gain;
			
			gain += score.get(r);
			score.set(r,gain);
			
		}
		
		return nbGain;

	}
	
	
	private int calculUcb(ArrayList<Manchot> manchot, int k){
		double result = 0.0;
		
		int indiceResult = 0;
		
		for(int j =0;j<nbTirage.size();j++){
			
			nbTirageTT += nbTirage.get(j);
			
		}
		
		for(int i =0; i< manchot.size();i++){
			
			
			double resultat = score.get(i)+k*(Math.sqrt(Math.log(nbTirageTT)/nbTirage.get(i)));
			ucb.set(i, resultat);

		}
		
		for(int j =0; j < manchot.size();j++){
						
			if(ucb.get(j)>result){
				result = ucb.get(j);
				indiceResult = j;
			}
			
			
		}
		
		return indiceResult;
	}
	
	
}
