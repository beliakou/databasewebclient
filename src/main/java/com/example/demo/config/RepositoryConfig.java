package com.example.demo.config;

import com.example.demo.components.validators.*;
import com.example.demo.domain.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Child.class);
        config.exposeIdsFor(Survey.class);
        config.exposeIdsFor(Diagnosis.class);
        config.exposeIdsFor(Disorder.class);
        config.exposeIdsFor(EducationProgram.class);
        config.exposeIdsFor(Recommendation.class);
    }

    @Override
    public void configureValidatingRepositoryEventListener(
            ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", new SurveyValidator());
        v.addValidator("beforeSave", new SurveyValidator());
        v.addValidator("beforeCreate", new ChildValidator());
        v.addValidator("beforeSave", new ChildValidator());
        v.addValidator("beforeCreate", new DiagnosisValidator());
        v.addValidator("beforeSave", new DiagnosisValidator());
        v.addValidator("beforeCreate", new DisorderValidator());
        v.addValidator("beforeSave", new DisorderValidator());
        v.addValidator("beforeCreate", new EducationProgramValidator());
        v.addValidator("beforeSave", new EducationProgramValidator());
        v.addValidator("beforeCreate", new RecommendationValidator());
        v.addValidator("beforeSave", new RecommendationValidator());
    }

}