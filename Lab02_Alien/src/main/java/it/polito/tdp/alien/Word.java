package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	/**
	 * Costruttore di {@link Word}.
	 * Il costruttore si assume il compito di formattare il testo
	 * in modo che la prima lettera di ogni parola sia {@code Maiusc}
	 * e tutto il resto sia {@code minus}.
	 * @param a : parola aliena
	 * @param t : relativa traduzione
	 */
	public Word(String a, String t) {
		this.alienWord = a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
		this.translation = t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase();
	}
	
	public Word(String a) {
		this.alienWord = a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	/**
	 * Verifica che le due {@code String} corrispondenti 
	 * alla parola aliena e alla sua traduzione siano inserite rispettando
	 * il vincolo [a-zA-Z],
	 * @return : {@code true} se è corretto, altrimenti {@code false}.
	 */
	public boolean verificaParole() {
		
		char[] verificaAlien = this.alienWord.toCharArray();
		for(char c : verificaAlien) {
			if(!Character.isLetter(c))
				return false;
		}
		
//		boolean allLettersTrans = this.translation.chars().allMatch(Character::isLetter);
	
		char[] verificaTrans = this.translation.toCharArray();
		for(char c : verificaTrans) {
			if(!Character.isLetter(c))
				return false;
		}
		
		return true;
	}


	
	
}
