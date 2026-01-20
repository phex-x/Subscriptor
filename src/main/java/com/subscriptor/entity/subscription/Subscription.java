package com.subscriptor.entity.subscription;

import com.subscriptor.entity.user.User;
import com.subscriptor.entity.SubscriptionPlan;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", referencedColumnName = "id", nullable = false)
    private SubscriptionPlan  plan;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SubscriptionStatus status;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "auto_renew", nullable = false)
    private boolean autoRenew;

    //getters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public SubscriptionPlan getPlan() { return plan; }
    public SubscriptionStatus getStatus() { return status; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isAutoRenew() { return autoRenew; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setPlan(SubscriptionPlan plan) { this.plan = plan; }
    public void setStatus(SubscriptionStatus status) { this.status = status; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setAutoRenew(boolean autoRenew) {}
}
