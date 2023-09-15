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
    private Coach anotherCoach;

        @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
//        System.out.println("In constructor: " + getClass().getSimpleName());
//        this.myCoach = theCoach;
//    }

//    @Autowired
//    public DemoController(Coach theCoach){
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

    @GetMapping("/check")
    public String check() {
            return "Comapring beans: myCoach == anotherCoach, ? " + (myCoach == anotherCoach);
    }


}
