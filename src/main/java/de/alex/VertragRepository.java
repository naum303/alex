package de.alex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import de.alex.types.Sparte;
import de.alex.types.Zahlungsweise;

@Component
public class VertragRepository {

	private List<Vertrag> vertraege = new ArrayList<>();

	public VertragRepository() {
		Vertrag vertrag = new Vertrag();
		vertrag.setSparte(Sparte.LEBEN);
		vertrag.setVersichertesObjekt("Berufsunfähigkeitsversicherung");
		vertrag.setVsnr("3.380.677.172");
		vertrag.setBeitrag(BigDecimal.valueOf(35.20));
		vertrag.setZahlungsweise(Zahlungsweise.MONATLICH);
		vertraege.add(vertrag);

		vertrag = new Vertrag();
		vertrag.setSparte(Sparte.LEBEN);
		vertrag.setVersichertesObjekt("Risiko-Leben");
		vertrag.setVsnr("3.380.677.123");
		vertrag.setBeitrag(BigDecimal.valueOf(12.20));
		vertrag.setZahlungsweise(Zahlungsweise.MONATLICH);
		vertraege.add(vertrag);

		vertrag = new Vertrag();
		vertrag.setSparte(Sparte.KRANKEN);
		vertrag.setVersichertesObjekt("Auslandsreise-Krankenversicherung");
		vertrag.setVsnr("79.116.975.12");
		vertrag.setBeitrag(BigDecimal.valueOf(25.20));
		vertrag.setZahlungsweise(Zahlungsweise.JAEHRLICH);
		vertraege.add(vertrag);

		vertrag = new Vertrag();
		vertrag.setSparte(Sparte.WOHNGEBAEUDE);
		vertrag.setVersichertesObjekt("Wohngebäude");
		vertrag.setVsnr("3.380.123.172");
		vertrag.setBeitrag(BigDecimal.valueOf(150.20));
		vertrag.setZahlungsweise(Zahlungsweise.QUARTAL);
		vertraege.add(vertrag);

		vertrag = new Vertrag();
		vertrag.setSparte(Sparte.HAUSRAT);
		vertrag.setVersichertesObjekt("Hausrat");
		vertrag.setVsnr("3.380.321.172");
		vertrag.setBeitrag(BigDecimal.valueOf(89.20));
		vertrag.setZahlungsweise(Zahlungsweise.JAEHRLICH);
		vertraege.add(vertrag);
	}

	public Vertrag getVertrag(Long vsnr) {
		for (Vertrag vertrag : vertraege) {
			String vertragVsnr = vertrag.getVsnr();
			vertragVsnr = vertragVsnr.replace(".", "");
			Long longVsnr = Long.valueOf(vertragVsnr);
			if (longVsnr.equals(vsnr)) {
				return vertrag;
			}
		}
		return null;
	}

	public List<Vertrag> getVertraege() {
		return vertraege;
	}

	public List<Vertrag> getVertraegeZurSparte(Sparte sparte) {
		return vertraege.parallelStream().filter(vertrag -> {
			return vertrag.getSparte() == sparte;
		}).collect(Collectors.toList());
	}
}
