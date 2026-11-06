package com.deca.api.Observers;

import com.deca.api.Models.JavaUser;
import com.deca.api.Services.UserCounterService;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class JavaUserCreatedListener {

    private final UserCounterService userCounterService;

    public JavaUserCreatedListener(UserCounterService userCounterService) {
        this.userCounterService = userCounterService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterUserCreated(JavaUser user) {

        System.out.println(
            "JavaUserCreatedListener: usuario creado correctamente"
        );

        userCounterService.increment();
    }
}