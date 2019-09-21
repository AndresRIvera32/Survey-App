package com.aws.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.spring.model.Survey;

public interface ISurveyDao  extends JpaRepository<Survey, Integer> {

}
