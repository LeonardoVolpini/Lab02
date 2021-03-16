package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private String parolaAliena;
	private List<String> traduzioni;
	
	public Word(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		this.traduzioni=new ArrayList<>();
		this.traduzioni.add(traduzione);
	}

	/*@Override
	public boolean equals(Object obj) {
		if ( this.parolaAliena.compareTo((String)obj)==0)
			return true;
		return false;
	}*/

	/*public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}

	public String getTraduzione() {
		return traduzione;
	}*/

	public String getParolaAliena() {
		return parolaAliena;
	}
	
	public void addTraduzione(String traduzione) {
		this.traduzioni.add(traduzione);
	}
	
	public String getTraduzioni() {
		String s ="";
		for (String x: this.traduzioni) {
			s=s+x+"\n";
		}
		return s;
	}

}
