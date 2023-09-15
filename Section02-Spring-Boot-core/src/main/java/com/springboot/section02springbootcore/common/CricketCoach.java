package com.springboot.section02springbootcore.common;

import com.springboot.section02springbootcore.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 Minutes.";
    }
}
