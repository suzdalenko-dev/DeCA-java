package com.deca.api.Observers;

import com.deca.api.Config.SpringContext;
import com.deca.api.Models.JavaUser;
import org.springframework.context.ApplicationEventPublisher;

import jakarta.persistence.PostPersist;

public class JavaUserObserver {

    @PostPersist
    public void afterSave(Object entity) {

        System.out.println(
            "JavaUserObserver: afterSave called for entity: " + entity
        );

        if (entity instanceof JavaUser user) {

            ApplicationEventPublisher publisher =
                SpringContext.getBean(ApplicationEventPublisher.class);

            publisher.publishEvent(user);
        }
    }
}