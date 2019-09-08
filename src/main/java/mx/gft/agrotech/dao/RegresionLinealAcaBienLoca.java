package mx.gft.agrotech.dao;

import org.springframework.stereotype.Repository;

@Repository
public class RegresionLinealAcaBienLoca {

	public double[] getSonora() {
		return new double[] {0.057903104211155826, 0.6547326415151266, -0.8828542237677934, 3.5092182331183976, -0.4661141705621663};
	}
	public double[] getAguascalientes() {
		return new double[] {0.10285506344544362, 1.6672422139851812, 1.492557499982823, -57.06372970953453, 0.9465533196631668};
	}
	public double[] getChihuahua() {
		return new double[] {-0.16232811795476484, -2.2860379040720784, 1.0976396069448326, 62.66089054578215, 0.4723908119827609};
	}
	public double[] getDurango() {
		return new double[] {-0.04864194446125538, -0.6690027670121294, 2.315855080899791, -10.120031085792872, -0.6058444610658515};
	}
	public double[] getTabasco() {
		return new double[] {-0.002958613459009103, 0.25982180589439585, -0.43771603093254113, 5.826296496571909, 0.025423998238069734};
	}
	public double[] getGenerico() {
		return new double[] {0.0d, 0.0d, -0.0d, -0.0d, -0.0d};
	}
}
