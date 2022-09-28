package no.hvl.dat108.oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import no.hvl.dat108.oppgave2.Ansatt;
import no.hvl.dat108.oppgave2.Kjonn;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Knut", "Knutsen", Kjonn.M, "vaskehjelp", 370000),
				new Ansatt("Ivar", "Aasen", Kjonn.M, "pedagog", 150000),
				new Ansatt("Ola", "Nordmann", Kjonn.M, "sekretaer", 150000),
				new Ansatt("Kari", "Nordmann", Kjonn.K, "headhunter", 900000),
				new Ansatt("Ole", "Brumm", Kjonn.A, "bjorn", 180000),
				new Ansatt("Kari", "Sjefesen", Kjonn.K, "sjef", 1500000),
				new Ansatt("Donald", "Duck", Kjonn.A, "and", 170000),
				new Ansatt("Fridtjoff", "Borg", Kjonn.A, "musiker", 800000));

		/**
		 * This lambda expression will take an employee as a parameter, and will map
		 * every surname to a list by using collect method
		 * 
		 * @param a - An employee Object
		 * @return etternavn - A List of surnames
		 */
		List<String> etternavn = ansatte.stream().map(a -> a.getEtternavn()).collect(Collectors.toList());
		System.out.println(" a)\n  Etternavn: ");
		etternavn.forEach((a) -> System.out.print("   " + a));

		/**
		 * This lambda expression will take an employee as a parameter, and will filter
		 * out every employee which is equal to the Enumerate value K representing
		 * female. By using count we get the amount of females.
		 * 
		 * @param x - An employee object
		 * @return antallvkinner - a long value representing amount of female.
		 */
		long antallKvinner = ansatte.stream().filter(x -> x.getKjonn() == Kjonn.K).count();
		System.out.println("\n\n b)\n  Antall kvinner: \n   " + antallKvinner);

		/**
		 * This lambda expression will first filter every employee whose gender is
		 * female by using the filter expression it will then use the mapToDouble method
		 * to retrieve the salary of every female, and lastly use the average function
		 * to get the avarage salay of the female employees.
		 * 
		 * @param x - an employee object
		 * @return gjennomsnittLonnK - average salary as double
		 */
		double gjennomsnittLonnK = ansatte.stream().filter(x -> x.getKjonn() == Kjonn.K)
				.mapToDouble(Ansatt::getAarslonn).average().getAsDouble();
		System.out.println("\n c)\n  Gjennomsnittslonn kvinner: \n   " + gjennomsnittLonnK);

		System.out.println("\n d)\n  Utskrift for lonnsokning: ");

		/**
		 * This lambda expression will print every employee whose title is "sjef"
		 * 
		 * @param x - an employee object
		 */
		ansatte.stream()
		.filter(x -> x.getStilling().contains("sjef"))
		.forEach(y -> System.out.print("  "+ y.toString()));
		System.out.println("\n  Utskrift etter lonnsokning: ");
		
		
		
		/** 
		 * This lambda expression will update the salary of every employee whose title is "sjef"
		 * @param x - an employee object
		 * @param prosentLonnOkning - a percentage to increase the salary with, given in double
		 */
		double prosentLonnsOkning = 1.007;
		ansatte.stream().forEach(x -> {
			if (x.getStilling().contains("sjef")) {
				x.setAarslonn((int) (x.getAarslonn() * prosentLonnsOkning));
			}
		});

		/**
		 * This lambda expression will print every employee whose title is "sjef"
		 * 
		 * @param x - an employee object
		 */
		ansatte.stream().filter(x -> x.getStilling().contains("sjef")).forEach(
				y -> System.out.print("  " +y.toString() + "\n"));

		/**
		 * This lambda expression will determine whether or not there is an employee with over 800k in salary
		 * @param x - an employee object
		 * @return true - if there exists an employee with over 800k in salary false otherwise
		 */
		boolean over800Tusen = ansatte.stream().anyMatch(x -> x.getAarslonn() > 800000);
		System.out.println("\n e)\n  Finnes det noen med over 800k i lønn?\n   " + over800Tusen);
		
		System.out.println("\n f)\n  Liste av alle ansatte: \n   ");
		ansatte.forEach((a)->System.out.println("   " + a.toString()));
		
		
		/**
		 * This lambda expression will filter out every employee whose salary is equal to the salary
		 * of the lowest paid employee. It compares the salary by finding the lowest paid worker and filtering every
		 * other worker whose salary is equal to that employee.
		 * @param a - an employee object
		 * @return lavestLonnListe - a list of employees who has the lowest salary.
		 */
		List<Ansatt> lavestLonnListe = ansatte.stream().filter(a -> a.getAarslonn() == ansatte.stream()
				.min(Comparator.comparing(Ansatt::getAarslonn))
				.get().getAarslonn()).toList();
		
		System.out.println("\n g)\n  Liste av ansatte med lavest lønn: \n   ");
		skrivUt(lavestLonnListe);
		
		/**
		 * This lambda expression will first filter every value divisible by 3 or 5, and then it will use
		 * the reduce function to add all the values together.
		 * @param heltall - a list of numbers from [1,1000>
		 * @return sumAlleDelelige - the total sum of every number divisible by 3 or 5.
		 */
		List<Integer> heltall = IntStream.range(1, 1000).boxed().toList();
		int sumAlleDelelige = heltall.stream()
				.filter(x -> x % 3 == 0 || x % 5 == 0)
				.reduce(0, (a, b) -> a + b);
		
		System.out.println("\n h)\n  Summen av alle heltall i [1,1000> delelig med 3 eller 5: \n   " + sumAlleDelelige);

	}
	/**
	 * This method will take a list as a parameter and will print every employee in said list
	 * @param list
	 */
	public static void skrivUt(List<Ansatt> list) {

		list.forEach((a) -> System.out.println("   " + a.toString()));
	}

}
