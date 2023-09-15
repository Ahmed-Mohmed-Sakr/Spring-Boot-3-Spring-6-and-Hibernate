package com.springboot.section02springbootcore.rest;

import com.springboot.section02springbootcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//    @Autowired
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach){
        this.myCoach = theCoach;
    }

//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
//        this.myCoach = theCoach;
//    }


//    @Autowired
//    public void setCoach(Coach theCoach){
//        this.myCoach = theCoach;
//    }

//    @Autowired
//    public void doSomeStaff(Coach theCoach){
//        this.myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
