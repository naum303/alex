package de.alex.types;

public enum Sparte {
	HAFTPFLICHT("Haftpflicht"),
	HAUSRAT("Hausrat"),
	WOHNGEBAEUDE("Wohngebäude"),
	KRAFTFAHRT("Kraftfahrt"),
	LEBEN("Leben"),
	KRANKEN("Kranken"),
	UNFALL("Unfall"),
	RECHTSSCHUTZ("Rechtsschutz"),
	FONDS("Fonds"),
	AUSLANDSREISEKRANKEN("Auslandsreisekranken");
	
	private String speech;
	
	private Sparte(String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return speech;
	}
}
