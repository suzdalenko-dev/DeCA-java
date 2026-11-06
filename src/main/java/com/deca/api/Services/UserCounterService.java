package com.deca.api.Services;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.deca.api.Models.UserCounter;
import com.deca.api.Repositories.UserCounterRepository;


@Service
public class UserCounterService {
    private final UserCounterRepository userCounterRepository;
    public UserCounterService(UserCounterRepository userCounterRepository) {
        this.userCounterRepository = userCounterRepository;
    }
    @Transactional 
    public void increment() {
        UserCounter counter = userCounterRepository.findFirstByOrderByIdAsc().orElseGet(() -> {
            UserCounter newCounter = new UserCounter();
            newCounter.setUserNumber(0);
            return newCounter;
        });
        counter.setUserNumber(counter.getUserNumber() + 1);
        userCounterRepository.save(counter);

        System.out.println(
            "Total usuarios: " + counter.getUserNumber()
        );
    }
}
