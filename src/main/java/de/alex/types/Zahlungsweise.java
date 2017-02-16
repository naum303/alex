package de.alex.types;

public enum Zahlungsweise {
	MONATLICH("Monatlich"),
	QUARTAL("Quartalsweise"),
	JAEHRLICH("Jährlich");
	
	private String speech;
	
	private Zahlungsweise(String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return speech;
	}

}