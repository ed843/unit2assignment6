package com.solvd.laba.services.strategy;

import com.solvd.laba.models.Screening;

import java.math.BigDecimal;

public class WeekendPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Screening screening) {
        return new BigDecimal("12.00");
    }
}
