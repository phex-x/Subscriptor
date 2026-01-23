package com.subscriptor.dto.subscriptionPlan;

import java.math.BigDecimal;

public class PlanResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String currency;
    private Integer durationDays;
    private boolean isRecurring;
    private Integer trialDays;

    //getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public String getCurrency() { return currency; }
    public Integer getDurationDays() { return durationDays; }
    public boolean isRecurring() { return isRecurring; }
    public Integer getTrialDays() { return trialDays; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDurationDays(Integer durationDays) { this.durationDays = durationDays; }
    public void setRecurring(boolean isRecurring) { this.isRecurring = isRecurring; }
    public void setTrialDays(Integer trialDays) { this.trialDays = trialDays; }
}
