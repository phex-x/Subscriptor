package com.subscriptor.service;

import com.subscriptor.dto.refund.RefundCreateRequest;
import com.subscriptor.dto.refund.RefundResponse;
import com.subscriptor.entity.refund.Refund;
import com.subscriptor.entity.refund.RefundStatus;
import com.subscriptor.mapper.RefundMapper;
import com.subscriptor.repository.PaymentRepository;
import com.subscriptor.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class RefundService {

    @Autowired
    private RefundRepository refundRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RefundMapper refundMapper;

    public RefundResponse createRefund(RefundCreateRequest refundCreateRequest) {
        if (refundRepository.findByPayment(paymentRepository.findById(refundCreateRequest.getPaymentId())
                .orElseThrow(() -> new BadCredentialsException("payment not found"))).isPresent()) {
                    throw new BadCredentialsException("refund already exists");
        }

        Refund refund = refundMapper.toEntity(refundCreateRequest);
        refund = refundRepository.save(refund);

        return refundMapper.toResponse(refund);
    }

    public RefundResponse getRefundById(Long id) {
        Refund refund = refundRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("refund not found"));

        return refundMapper.toResponse(refund);
    }

    public RefundResponse changeStatus(Long id, RefundStatus status) {
        Refund refund = refundRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("refund not found"));
        refund.setStatus(status);
        refund = refundRepository.save(refund);

        return refundMapper.toResponse(refund);
    }

    public void deleteRefund(Long id) {
        Refund refund = refundRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("refund not found"));

        refundRepository.delete(refund);
    }
}
