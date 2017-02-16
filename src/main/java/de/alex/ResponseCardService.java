package de.alex;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amazon.speech.ui.SimpleCard;
@Component
public class ResponseCardService {
	
	public SimpleCard getCardByVertrag(Vertrag v) {
		SimpleCard card = new SimpleCard();
		card.setTitle("Informationen zum Vertrag");
		
		StringBuffer buffer = new StringBuffer();
		appendVertrag(v, buffer);
		card.setContent(buffer.toString());
		return card;
	}

	private void appendVertrag(Vertrag v, StringBuffer buffer) {
		buffer.append("\nSparte: " + v.getSparte().getSpeech());
		buffer.append("\nVersichert: " + v.getVersichertesObjekt());
		buffer.append("\nBeitrag: " + v.getBeitrag()+"€");
		buffer.append("\nZahlungsweise: " + v.getZahlungsweise());
	}
	
	public SimpleCard getCardbyListe(List<Vertrag> list) {
		SimpleCard card = new SimpleCard();
		card.setTitle("Informationen zur Sparte");
		StringBuffer buffer = new StringBuffer();
		for (Vertrag vertrag : list) {
			appendVertrag(vertrag, buffer);
			buffer.append("\n");
		}
		card.setContent(buffer.toString());
		return card;
	}
	
	public SimpleCard getCardbyListe(List<Vertrag> list, String sparte) {
		SimpleCard card = new SimpleCard();
		card.setTitle("Informationen zur Sparte "+sparte);
		StringBuffer buffer = new StringBuffer();
		for (Vertrag vertrag : list) {
			appendVertrag(vertrag, buffer);
			buffer.append("\n");
		}
		card.setContent(buffer.toString());
		return card;
	}
}
