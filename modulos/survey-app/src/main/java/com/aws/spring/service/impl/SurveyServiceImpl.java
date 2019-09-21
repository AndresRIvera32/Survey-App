package com.aws.spring.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.spring.dao.ISurveyDao;
import com.aws.spring.model.Survey;
import com.aws.spring.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService{
	
	private Logger logger = Logger.getLogger(SurveyServiceImpl.class);

	@Autowired
	private ISurveyDao surveyDao;

	@Override
	public Survey guardarDatos(Survey survey) {
		logger.info("SAVE: "+survey.toString());
		return surveyDao.save(survey);
	}
	
	public List<Survey> getAll(){
		List<Survey> ls = surveyDao.findAll();
		return ls;
	}

}
