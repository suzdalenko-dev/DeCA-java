package com.deca.api.Observers;

import com.deca.api.Models.JavaUser;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class JavaUserObserver {
     @PrePersist
    public void beforeInsert(Object entity) {
        System.out.println("@PrePersist: " + entity);
    }

    @PreUpdate
    public void beforeUpdate(Object entity) {
        System.out.println("@PreUpdate: " + entity);
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        System.out.println("@PostUpdate: " + entity);
    }

    @PreRemove
    public void beforeDelete(Object entity) {
        System.out.println("@PreRemove: " + entity);
    }

    @PostRemove
    public void afterDelete(Object entity) {
        System.out.println("@PostRemove: " + entity);
    }

    @PostLoad
    public void afterLoad(Object entity) {
        System.out.println("@PostLoad: " + entity);
    }
    @PostPersist 
    public void afterSave(Object entity) {
        System.out.println("JavaUserObserver: afterSave called for entity: " + entity);
        /*
        Buscamos si existe la linea de UserCounter y si existe la recuperamos y actualizamos el valor, si no existe la creamos con valor 1
        */
        if (entity instanceof JavaUser user) {
            increment();
        }
    }
}

