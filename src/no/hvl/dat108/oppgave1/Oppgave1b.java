package no.hvl.dat108.oppgave1;

import java.util.function.BiFunction;

public class Oppgave1b {
	public static void main(String[] args) {

		BiFunction<Integer,Integer,Integer> summer = (x,y)->x+y;
		BiFunction<Integer,Integer,Integer> storste = (x,y)-> Math.max(x,y);
		BiFunction<Integer,Integer,Integer> differanse = (x,y)-> Math.abs(x-y);
		
		System.out.println(beregn(12,13,summer));
		System.out.println(beregn(-5,3,storste));
		System.out.println(beregn(54,45,differanse));

	}
	
	public static int beregn(int a, int b, BiFunction<Integer,Integer,Integer>func) {
		return func.apply(a, b);
	} 
}
