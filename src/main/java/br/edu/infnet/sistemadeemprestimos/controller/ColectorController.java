package br.edu.infnet.sistemadeemprestimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.infnet.sistemadeemprestimos.model.Coletor;
import br.edu.infnet.sistemadeemprestimos.service.ColetorService;

@Controller
@RequestMapping(value = "/coletor")
public class ColectorController {
	
	@Autowired
	private ColetorService coletorService;
	
	@RequestMapping(value="/consultarColetor/{idColetor}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> consultarColetor(@PathVariable("idColetor") String idColetor) {
		
		Coletor coletor = coletorService.getColetor(Integer.valueOf(idColetor));
		
		return new ResponseEntity<>(coletor, HttpStatus.OK);
	}

}
