package com.springboot.section02springbootcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volly.";
    }
}
