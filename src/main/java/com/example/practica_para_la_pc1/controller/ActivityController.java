package com.example.practica_para_la_pc1.controller;

import com.example.practica_para_la_pc1.service.ActivityService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/my-activity")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

}
