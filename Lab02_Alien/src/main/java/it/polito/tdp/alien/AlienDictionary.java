package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<Word> dizionario;
	Map<String,Word> dizMap;
	
	
	public AlienDictionary() {
		dizionario= new ArrayList<Word>();
		dizMap=new TreeMap<>();
	}

	public void addWord (String parolaAliena, String traduzione) {
		Word temp = this.searchAlienWord(parolaAliena);
		if (temp==null) {
			temp =  new Word(parolaAliena,traduzione);
			this.dizionario.add(temp);
			this.dizMap.put(parolaAliena, temp);
		}else {
			//temp.setTraduzione(traduzione);
			temp.addTraduzione(traduzione);
		}
	}
	
	public String transalteWord (String parolaAliena) {
		Word temp=this.searchAlienWord(parolaAliena);
		if (temp!=null)
			return temp.getTraduzioni();
		else 
			return null;
	}
	
	public Word searchAlienWord (String parolaAliena) {
		return this.dizMap.get(parolaAliena);
	}
}
