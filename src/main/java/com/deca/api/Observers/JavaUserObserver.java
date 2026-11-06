package com.deca.api.Observers;

import com.deca.api.Config.SpringContext;
import com.deca.api.Models.JavaUser;

import jakarta.persistence.PostPersist;

public class JavaUserObserver {

    @PostPersist
    public void afterSave(Object entity) {

        System.out.println(
            "JavaUserObserver: afterSave called for entity: " + entity
        );

        if (entity instanceof JavaUser user) {

            // Publicamos el evento sin consultar repositorios
            SpringContext.publishEvent(user);
        }
    }
}