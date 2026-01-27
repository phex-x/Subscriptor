package com.subscriptor.mapper;

import com.subscriptor.dto.refund.RefundCreateRequest;
import com.subscriptor.dto.refund.RefundResponse;
import com.subscriptor.entity.refund.Refund;
import com.subscriptor.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class RefundMapper {

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentRepository paymentRepository;

    public Refund toEntity(RefundCreateRequest refundCreateRequest) {
        Refund refund = new Refund();
        refund.setPayment(paymentRepository.findById(refundCreateRequest.getPaymentId())
                .orElseThrow(() -> new BadCredentialsException("Payment not found")));
        refund.setAmount(refundCreateRequest.getAmount());
        refund.setReason(refundCreateRequest.getReason());

        return refund;
    }

    public RefundResponse toResponse(Refund refund) {
        RefundResponse refundResponse = new RefundResponse();
        refundResponse.setId(refund.getId());
        refundResponse.setPayment(paymentMapper.toResponse(refund.getPayment()));
        refundResponse.setAmount(refund.getAmount());
        refundResponse.setStatus(refund.getStatus());
        refundResponse.setReason(refund.getReason());
        refundResponse.setCreatedAt(refund.getCreatedAt());

        return refundResponse;
    }
}
