package com.subscriptor.dto.payment;

import com.subscriptor.dto.subscription.SubscriptionResponse;
import com.subscriptor.dto.user.UserResponse;
import com.subscriptor.entity.payment.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponse {
    private Long id;
    private UserResponse user;
    private SubscriptionResponse subscription;
    private BigDecimal amount;
    private String currency;
    private PaymentStatus status;
    private LocalDateTime createdAt;

    //getters
    public Long getId() { return id; }
    public UserResponse getUser() { return user; }
    public SubscriptionResponse getSubscription() { return subscription; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public PaymentStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setUser(UserResponse user) { this.user = user; }
    public void setSubscription(SubscriptionResponse subscription) { this.subscription = subscription; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setStatus(PaymentStatus status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
