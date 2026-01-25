package com.subscriptor.dto.refund;

import java.math.BigDecimal;

public class RefundCreateRequest {
    private Long paymentId;
    private BigDecimal amount;
    private String reason;

    //getters
    public Long getPaymentId() { return paymentId; }
    public BigDecimal getAmount() { return amount; }
    public String getReason() { return reason; }

    //setters
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setReason(String reason) { this.reason = reason; }
}
