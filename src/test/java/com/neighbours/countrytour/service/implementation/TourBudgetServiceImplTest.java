package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.configuration.AppConfig;
import com.neighbours.countrytour.service.template.TourBudgetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@DisplayName("Testing TourBudgetServiceImpl")
class TourBudgetServiceImplTest {

    @Autowired
    private TourBudgetService tourBudgetService;

    @DisplayName("Testing method getFullToursCount(..)")
    @Test
    void getFullToursCount() {

        int fullToursCount = tourBudgetService.getFullToursCount(200, 1200, 5);
        assertEquals(1, fullToursCount);
    }

    @DisplayName("Testing method getLeftover(..)")
    @Test
    void getLeftover() {

        int leftover = tourBudgetService.getLeftover(200, 1200, 5, 1);
        assertEquals(200, leftover);
    }
}