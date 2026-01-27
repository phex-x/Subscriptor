package com.subscriptor.dto.payment;

import java.math.BigDecimal;

public class PaymentCreateRequest {
    private Long userId;
    private Long subscriptionId;
    private BigDecimal amount;
    private String currency;

    //getters
    public Long getUserId() { return userId; }
    public Long getSubscriptionId() { return subscriptionId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }

    //setters
    public void setUserId(Long userId) { this.userId = userId; }
    public void setSubscriptionId(Long subscriptionId) { this.subscriptionId = subscriptionId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
}
