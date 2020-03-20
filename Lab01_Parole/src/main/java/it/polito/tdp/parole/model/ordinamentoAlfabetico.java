package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ordinamentoAlfabetico implements Comparator<String> {



	@Override
	public int compare(String o1, String o2) {
		int i;
		i=o1.compareTo(o2);
		return i;
	}

}
