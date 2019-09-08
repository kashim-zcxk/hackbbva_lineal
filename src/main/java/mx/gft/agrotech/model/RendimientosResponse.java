package mx.gft.agrotech.model;

public class RendimientosResponse {

	private EnumRendimiento rendimiento;
	private Double rendimientoReal;

	public EnumRendimiento getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(EnumRendimiento rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Double getRendimientoReal() {
		return rendimientoReal;
	}

	public void setRendimientoReal(Double rendimientoReal) {
		this.rendimientoReal = rendimientoReal;
	}

}
