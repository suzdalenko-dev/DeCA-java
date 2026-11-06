package com.deca.api.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deca.api.Models.UserCounter;
import com.deca.api.Repositories.UserCounterRepository;

@Service
public class UserCounterService {

    private final UserCounterRepository userCounterRepository;

    public UserCounterService(
        UserCounterRepository userCounterRepository
    ) {
        this.userCounterRepository = userCounterRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void increment() {

        UserCounter counter = userCounterRepository
            .findFirstByOrderByIdAsc()
            .orElseGet(() -> {
                UserCounter newCounter = new UserCounter();
                newCounter.setUserNumber(0);
                return newCounter;
            });

        int currentValue = counter.getUserNumber() == null
            ? 0
            : counter.getUserNumber();

        counter.setUserNumber(currentValue + 1);

        userCounterRepository.save(counter);

        System.out.println(
            "Total usuarios: " + counter.getUserNumber()
        );
    }
}