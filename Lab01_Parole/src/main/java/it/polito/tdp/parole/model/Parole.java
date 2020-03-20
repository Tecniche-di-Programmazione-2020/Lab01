package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	List<String> lista;	
	

	public Parole() {
		lista=new LinkedList<String>();
		//TODO
	}
	
	public void addParola(String p) {
		lista.add(p);
		
	}
	
	public List<String> getElenco() {
		Collections.sort(lista, new ordinamentoAlfabetico());
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}
	
	public boolean cancella(String p) {
		if(lista.remove(p)==true)return true;
		
			
		else return false;
		
		
	}
	
	
	
}
