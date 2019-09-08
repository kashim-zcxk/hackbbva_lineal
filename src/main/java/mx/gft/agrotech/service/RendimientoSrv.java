package mx.gft.agrotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gft.agrotech.dao.RegresionLinealAcaBienLoca;
import mx.gft.agrotech.model.EnumRendimiento;
import mx.gft.agrotech.model.RendimientosResponse;

@Service
public class RendimientoSrv {

	@Autowired
	private RegresionLinealAcaBienLoca regresionLinealAcaBienLoca;

	private static final double umbra1 = 6;
	private static final double umbra2 = 12;

	public RendimientosResponse getRendimiento(String estado, Double climaMax, Double climaMed, Double lluvia,
			Double macanizado) {
		RendimientosResponse rend = new RendimientosResponse();
		double[] betas = null;
		switch (estado.toLowerCase()) {
		case "sonora":
			betas = regresionLinealAcaBienLoca.getSonora();
			break;
		case "aguascalientes":
			betas = regresionLinealAcaBienLoca.getAguascalientes();
			break;
		case "chihuahua":
			betas = regresionLinealAcaBienLoca.getChihuahua();
			break;
		case "durango":
			betas = regresionLinealAcaBienLoca.getDurango();
			break;
		case "tabasco":
			betas = regresionLinealAcaBienLoca.getTabasco();
			break;
		default:
			betas = regresionLinealAcaBienLoca.getGenerico();
			break;
		}
		double calc = calculoMamalon(betas, climaMax, climaMed, lluvia, macanizado);
		if(calc >= umbra2) {
			rend.setRendimiento(EnumRendimiento.ALTO);
		}else if(umbra2 > calc && calc > umbra1) {
			rend.setRendimiento(EnumRendimiento.MEDIO);
		}else {
			rend.setRendimiento(EnumRendimiento.BAJO);
		}
		rend.setRendimientoReal(calc);
		return rend;
	}
	
	private double calculoMamalon(double[] betas, Double climaMax, Double climaMed, Double lluvia,
			Double macanizado) {
		return (betas[0]*lluvia) + (betas[1]*climaMax) +  (betas[2]*climaMed) + betas[3] +  betas[4];
	}
}
