package com.aws.spring.service;

import java.util.List;

import com.aws.spring.model.Survey;

public interface ISurveyService {
	
	Survey guardarDatos(Survey feedback);
	
	List<Survey> getAll();

}
