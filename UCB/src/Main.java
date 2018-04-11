import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		ArrayList<Manchot> manchot = creerManchot(150);
		

		
		StratUcb ucb = new StratUcb();
		
		System.out.println("résultat de ucb : " + ucb.rechercheUcb(15000, manchot,20));
		
		StratAlea rand = new StratAlea();
		
		System.out.println("résultat de l'aléatoire : "+rand.rechercheAlea(15000, manchot));
		
		
		StratGloutonne glouton = new StratGloutonne();
		
		System.out.println("résultat de glouton : "+glouton.rechercheGloutonne(15000, manchot));
		
		

	}
	
	public static ArrayList<Manchot> creerManchot(int nb){
		
		ArrayList<Manchot> manchot = new ArrayList<Manchot>();
		for(int i = 0; i<nb;i++){
			Random r = new Random();
			int Low = -10;
			int High = 10;
			int ResultEspe = r.nextInt(High-Low) + Low;
			
			Random r2 = new Random();
			int Low2 = 0;
			int High2 = 10;
			int ResultVar = r.nextInt(High-Low) + Low;
			
			manchot.add(new Manchot(ResultVar,ResultEspe));
			
		}
		
		return manchot;
	}

}
