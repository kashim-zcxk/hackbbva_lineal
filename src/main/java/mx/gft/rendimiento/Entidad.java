package mx.gft.rendimiento;

public class Entidad {

	private Double rendimiento;
	private Integer num;

	public Entidad(Double rendimiento, Integer num) {
		super();
		this.rendimiento = rendimiento;
		this.num = num;
	}

	public Double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
