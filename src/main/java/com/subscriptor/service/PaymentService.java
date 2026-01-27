package com.subscriptor.service;

import com.subscriptor.dto.payment.PaymentCreateRequest;
import com.subscriptor.dto.payment.PaymentResponse;
import com.subscriptor.entity.payment.Payment;
import com.subscriptor.entity.payment.PaymentStatus;
import com.subscriptor.mapper.PaymentMapper;
import com.subscriptor.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentResponse createPayment(PaymentCreateRequest paymentCreateRequest) {
        Payment payment = paymentMapper.toEntity(paymentCreateRequest);
        payment = paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    public PaymentResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Payment not found"));

        return paymentMapper.toResponse(payment);
    }

    public PaymentResponse changePaymentStatus(Long id, PaymentStatus paymentStatus) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Payment not found"));
        payment.setStatus(paymentStatus);
        payment = paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new BadCredentialsException("Payment not found");
        }

        paymentRepository.deleteById(id);
    }
}
