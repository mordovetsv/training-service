package com.planner.trainingservice.controller;

import com.planner.trainingservice.TrainingServiceApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TrainingServiceApplication.class)
@DisplayName("HomeController")
@Tag("controller")
class HomeControllerTest {

    @Autowired
    private HomeController homeController;

    @DisplayName("welcome() - normal return")
    @Test
    void welcome_normalReturn() {
        Assertions.assertEquals(homeController.welcome(), "index.html");
    }


}