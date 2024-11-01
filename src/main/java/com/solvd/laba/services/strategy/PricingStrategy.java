package com.solvd.laba.services.strategy;

import com.solvd.laba.models.Screening;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Screening screening);
}
