package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.*;


public class Parole {
		
	List<String> Parole; 
	
	public Parole() {
		
		//Parole = new LinkedList<String>();
		Parole = new ArrayList<String>();
		
	}
	
	public void addParola(String p) {
		
		Parole.add(p);
		
	}
	
	public List<String> getElenco() {
		
		Collections.sort(Parole);
		
		return Parole;
		
	}
	
	public void cancella(String p) {
		
		for(String s : Parole)
			if(s.compareTo(p) == 0)
				Parole.remove(s);
		
	}
	
	public void reset() {
		
		Parole.clear();
		
	}
	
}
