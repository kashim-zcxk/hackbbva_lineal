package mx.gft.rendimiento;

public class EntidadDataset {

	private String prep;
	private String tmax;
	private String tmed;
	private String res;
	
	
	public EntidadDataset(String prep, String tmax, String tmed, String res) {
		super();
		this.prep = prep;
		this.tmax = tmax;
		this.tmed = tmed;
		this.res = res;
	}
	public String getPrep() {
		return prep;
	}
	public void setPrep(String prep) {
		this.prep = prep;
	}
	public String getTmax() {
		return tmax;
	}
	public void setTmax(String tmax) {
		this.tmax = tmax;
	}
	public String getTmed() {
		return tmed;
	}
	public void setTmed(String tmed) {
		this.tmed = tmed;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	@Override
	public String toString() {
		return prep + "," + tmax + "," + tmed + "," + res;
	}
	
	
}
