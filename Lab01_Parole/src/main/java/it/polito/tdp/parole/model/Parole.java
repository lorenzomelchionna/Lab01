package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	LinkedList<String> Parole; 
	
	public Parole() {
		
		//TODO
		Parole = new LinkedList<String>();
		
	}
	
	public void addParola(String p) {
		
		//TODO
		Parole.add(p);
		
	}
	
	public List<String> getElenco() {
		
		//TODO
		Collections.sort(Parole);
		
		return Parole;
		
	}
	
	public void reset() {
		
		// TODO
		Parole.clear();
		
	}

}
