package com.deca.api.Config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {

        SpringContext.applicationContext = context;
    }

    public static <T> T getBean(Class<T> beanClass) {

        if (applicationContext == null) {
            throw new IllegalStateException(
                "El contexto de Spring todavía no está inicializado"
            );
        }

        return applicationContext.getBean(beanClass);
    }
}