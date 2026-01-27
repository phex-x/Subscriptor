package com.subscriptor.dto.subscription;

import com.subscriptor.dto.subscriptionPlan.PlanResponse;
import com.subscriptor.dto.user.UserResponse;
import com.subscriptor.entity.subscription.SubscriptionStatus;

import java.time.LocalDate;

public class SubscriptionResponse {
    private Long id;
    private UserResponse user;
    private PlanResponse plan;
    private SubscriptionStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean autoRenew;

    //getters
    public Long getId() { return this.id; }
    public UserResponse getUser() { return this.user; }
    public PlanResponse getPlan() { return this.plan; }
    public SubscriptionStatus getStatus() { return this.status; }
    public LocalDate getStartDate() { return this.startDate; }
    public LocalDate getEndDate() { return this.endDate; }
    public boolean isAutoRenew() { return this.autoRenew; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setUser(UserResponse user) { this.user = user; }
    public void setPlan(PlanResponse plan) { this.plan = plan; }
    public void setStatus(SubscriptionStatus status) { this.status = status; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setAutoRenew(boolean autoRenew) {
        this.autoRenew = autoRenew;
    }
}
