package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dizionario;
	int numeroparole = 0;
	
	public AlienDictionary() {
		dizionario = new ArrayList<>();
	}

	public String getNumeroparole() {
		return Integer.toString(numeroparole);
	}

	/** 
	 * Aggiunge una nuova {@link Word} al dizionario, dopo aver verificato 
	 * che non sia già presente. Se la parola è già presente sostituisco la traduzione.
	 * @param alien : parola aliena da aggiungere
	 * @param trans : traduzione in italiano
	 */
	public void addWord(String alien, String trans) {
		Word w = new Word(alien, trans);
		if(w.verificaParole()) {
			if(!dizionario.contains(w)) {
				dizionario.add(w);
				numeroparole++;
			} else {
				// devo sostituire!
				
				Word wordEliminare = null;
				for(Word u : this.dizionario) {
					if(u.equals(w))
						wordEliminare = new Word(u.getAlienWord(), u.getTranslation()); // oppure puntatore??
				}
				dizionario.remove(wordEliminare);
				dizionario.add(w);
				numeroparole++;
			}
		}
	}
	
	/**
	 * Data una parola aliena restituisce la traduzione
	 * @param alien : parola aliena da tradurre
	 * @return : trauzione se la parola è presente altrimenti {@code null}.
	 */
	public String TranslateWord(String alien) {
		Word w = new Word(alien);
		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		return "La parola non è contenuta nel dizionario.";
	}
	
	
}
