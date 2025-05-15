package com.iron.labAdvancedPostman.config;

import com.iron.labAdvancedPostman.services.EarlyBirdDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "true")
    public EarlyBirdDiscountService earlyBirdDiscountService(){
        return new EarlyBirdDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "false", matchIfMissing = true)
    public EarlyBirdDiscountService earlyBirdDiscountServiceDisabled(){
        return new EarlyBirdDiscountService(){
            @Override
            public String discountPercentage(LocalDate bookingDate, LocalDate eventDate) {
                return "El servicio no está activado";
            }
        };
    }

}
