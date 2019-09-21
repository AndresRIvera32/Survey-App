package com.aws.spring.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.spring.dto.RespuestaApi;
import com.aws.spring.model.Survey;
import com.aws.spring.service.ISurveyService;


@RestController
@CrossOrigin
@RequestMapping("api/survey")
public class ApiSurveyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiSurveyController.class);

	@Autowired
	private ISurveyService surveyService;
	
	@PostMapping(value="registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> guardarFeedBack(
			@RequestBody Survey survey){
		try {
			//User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//survey.setIdUsuario(usuario.getUsername());
			Survey surv = surveyService.guardarDatos(survey);
			logger.info(surv.toString());
			int x = 0;
			x=x+1;
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",""), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listar")
	public ResponseEntity<List<Survey>>  getAll(){
		try {
			return new ResponseEntity<List<Survey>>(
					surveyService.getAll(), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
