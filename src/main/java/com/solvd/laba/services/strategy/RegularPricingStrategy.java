package com.solvd.laba.services.strategy;

import com.solvd.laba.models.Screening;

import java.math.BigDecimal;

public class RegularPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Screening screening) {
        return new BigDecimal("10.00");
    }
}