package mx.gft.agrotech.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.gft.agrotech.model.RendimientosResponse;
import mx.gft.agrotech.service.RendimientoSrv;

@RestController
@RequestMapping("/api/v0/agrotech")
public class ApiController {

	@Autowired
	private RendimientoSrv rendimientoSrv;
	
    /*get orden*/
	@GetMapping(path = "/rendimientos", produces = "application/json")
	public ResponseEntity<RendimientosResponse> getRendimientos(
			@RequestParam String estado, 
			@RequestParam Double climaMax, 
			@RequestParam Double climaMed,
			@RequestParam Double lluvia,
			@RequestParam Double mecanizado) {
		return new ResponseEntity<>(rendimientoSrv.getRendimiento(estado, climaMax, climaMed, lluvia, mecanizado), HttpStatus.OK);
	}
	
}
