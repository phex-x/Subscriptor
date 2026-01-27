package com.subscriptor.dto.subscription;

import java.time.LocalDate;

public class SubscriptionCreateRequest {
    private Long userId;
    private Long planId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean autoRenew;


    //getters
    public Long getUserId() { return userId; }
    public Long getPlanId() { return planId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isAutoRenew() { return autoRenew; }

    //setters
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPlanId(Long planId) { this.planId = planId; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setAutoRenew(boolean autoRenew) { this.autoRenew = autoRenew; }
}
