package com.deca.api.Observers;

import com.deca.api.Config.SpringContext;
import com.deca.api.Models.JavaUser;
import com.deca.api.Services.UserCounterService;

import jakarta.persistence.PostPersist;

public class JavaUserObserver {

    @PostPersist
    public void afterSave(Object entity) {

        System.out.println(
            "JavaUserObserver: afterSave called for entity: " + entity
        );

        if (entity instanceof JavaUser user) {

            UserCounterService userCounterService =
                SpringContext.getBean(UserCounterService.class);

            userCounterService.increment();
        }
    }
}