package com.subscriptor.dto.refund;

import com.subscriptor.dto.payment.PaymentResponse;
import com.subscriptor.entity.refund.RefundStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RefundResponse {
    private Long id;
    private PaymentResponse payment;
    private BigDecimal amount;
    private RefundStatus status;
    private String reason;
    private LocalDateTime createdAt;

    //getters
    public Long getId() { return id; }
    public PaymentResponse getPayment() { return payment; }
    public BigDecimal getAmount() { return amount; }
    public RefundStatus getStatus() { return status; }
    public String getReason() { return reason; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setPayment(PaymentResponse payment) { this.payment = payment; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setStatus(RefundStatus status) { this.status = status; }
    public void setReason(String reason) { this.reason = reason; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
