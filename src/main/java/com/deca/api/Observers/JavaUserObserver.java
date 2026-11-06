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

