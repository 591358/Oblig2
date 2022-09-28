package no.hvl.dat108.oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Knut", "Knutsen", Kjonn.M, "vaskehjelp", 600000),
				new Ansatt("Ivar", "Aasen", Kjonn.M, "pedagog", 350000),
				new Ansatt("Ola", "Nordmann", Kjonn.M, "sekretaer", 700000),
				new Ansatt("Kari", "Nordmann", Kjonn.K, "sjef", 1200000),
				new Ansatt("Ole", "Brumm", Kjonn.A, "bamse", 70000));

		int fastkroneTillegg = 2;
		double prosentTillegg = 1.2;
		int fastKroneTilleggLavLonn = 5;
		double prosentTilleggLavLonn = 1.4;
		
		
		
		Function<Ansatt, Integer> fast = (x) -> (int) (x.getAarslonn() + fastkroneTillegg);
		Function<Ansatt, Integer> prosent = (x) -> (int) (x.getAarslonn() * prosentTillegg);
		Function<Ansatt, Integer> lavLonn = (x) -> x.getAarslonn() < 100000 ? x.getAarslonn() + fastKroneTilleggLavLonn : x.getAarslonn();
		Function<Ansatt, Integer> lavLonnProsent = (x) -> x.getAarslonn() < 100000 ? 
				(int) (x.getAarslonn() * prosentTilleggLavLonn) : x.getAarslonn();
		
		
		System.out.println(" For fast kronetillegg:");
		lonnsoppgjor(ansatte, fast);
		System.out.println(" For prosent tillegg:");
		lonnsoppgjor(ansatte, prosent);
		System.out.println(" For lav lonn fast tillegg:");
		lonnsoppgjor(ansatte, lavLonn);
		System.out.println(" For lav lonn prosent tillegg:");
		lonnsoppgjor(ansatte, lavLonnProsent);

	}
	/**
	 * This method will take a list of employees and a bifunction as paramater,
	 * it will then apply the function on the list of employees. It will print the result before and after
	 * applying the function.
	 * @param ansatte - a list of employees
	 * @param f - a bifunction
	 */
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> f) {
		ansatte.forEach(ansatt->System.out.print("  " + ansatt.getAarslonn()));
		ansatte.forEach(ansatt -> ansatt.setAarslonn(f.apply(ansatt)));
		System.out.println("\n Etter tillegg:");
		ansatte.forEach(ansatt->System.out.print("  " +ansatt.getAarslonn()));
		System.out.println("\n");
	}

}
