package de.alex;

import java.math.BigDecimal;

import de.alex.types.Sparte;
import de.alex.types.Zahlungsweise;

public class Vertrag {
	private Sparte sparte;
	private String versichertesObjekt;
	private BigDecimal beitrag;
	private String vsnr;
	private Zahlungsweise zahlungsweise;
	
	public Zahlungsweise getZahlungsweise() {
		return zahlungsweise;
	}
	public void setZahlungsweise(Zahlungsweise zahlungsweise) {
		this.zahlungsweise = zahlungsweise;
	}
	public Sparte getSparte() {
		return sparte;
	}
	public void setSparte(Sparte sparte) {
		this.sparte = sparte;
	}
	public String getVersichertesObjekt() {
		return versichertesObjekt;
	}
	public void setVersichertesObjekt(String versichertesObjekt) {
		this.versichertesObjekt = versichertesObjekt;
	}
	public BigDecimal getBeitrag() {
		return beitrag;
	}
	public void setBeitrag(BigDecimal beitrag) {
		this.beitrag = beitrag;
	}
	public String getVsnr() {
		return vsnr;
	}
	public void setVsnr(String vsnr) {
		this.vsnr = vsnr;
	}
}
