package com.skr.kramphub.informationapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Config Class for Async operations
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

    /**
     * Async Executor for creating Thread pool executor
     *
     * @return instance of {@link Executor}
     */
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }
}
