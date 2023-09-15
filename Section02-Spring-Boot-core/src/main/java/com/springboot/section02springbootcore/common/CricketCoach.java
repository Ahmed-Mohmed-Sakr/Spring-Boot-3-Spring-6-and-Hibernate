package com.springboot.section02springbootcore.common;

import com.springboot.section02springbootcore.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void doMyStrartupStaff() {
        System.out.println("In doMyStrartupStaff(): " + getClass().getSimpleName());
    }
    // define our destroy method
    @PreDestroy
    public void doMyCleanupStaff() {
        System.out.println("In doMyCleanupStaff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 Minutes.";
    }
}
