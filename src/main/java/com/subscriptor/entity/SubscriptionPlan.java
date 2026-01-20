package com.subscriptor.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "durationDays", nullable = false)
    private Integer durationDays;

    @Column(name = "is_recurring", nullable = false)
    private Boolean isRecurring;

    @Column(name = "trial_days", nullable = false)
    private Integer trialDays;

    //getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public String getCurrency() { return currency; }
    public Integer getDurationDays() { return durationDays; }
    public Boolean getIsRecurring() { return isRecurring; }
    public Integer getTrialDays() { return trialDays; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDurationDays(Integer durationDays) { this.durationDays = durationDays; }
    public void setIsRecurring(Boolean isRecurring) { this.isRecurring = isRecurring; }
}
