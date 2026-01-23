package com.subscriptor.mapper;

import com.subscriptor.dto.payment.PaymentCreateRequest;
import com.subscriptor.dto.payment.PaymentResponse;
import com.subscriptor.entity.payment.Payment;
import com.subscriptor.repository.SubscriptionRepository;
import com.subscriptor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionMapper subscriptionMapper;

    public Payment toEntity(PaymentCreateRequest paymentCreateRequest) {
        Payment payment = new Payment();
        payment.setUser(userRepository.findById(paymentCreateRequest.getUserId())
                .orElseThrow(() -> new BadCredentialsException("User not found")));
        payment.setSubscription(subscriptionRepository.findById(paymentCreateRequest.getSubscriptionId())
        .orElseThrow(() -> new BadCredentialsException("Subscription not found")));
        payment.setAmount(paymentCreateRequest.getAmount());
        payment.setCurrency(paymentCreateRequest.getCurrency());

        return payment;
    }

    public PaymentResponse toResponse(Payment payment) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setId(payment.getId());
        paymentResponse.setUser(userMapper.toResponse(payment.getUser()));
        paymentResponse.setSubscription(subscriptionMapper.toResponse(payment.getSubscription()));
        paymentResponse.setAmount(payment.getAmount());
        paymentResponse.setCurrency(payment.getCurrency());
        paymentResponse.setStatus(payment.getStatus());
        paymentResponse.setCreatedAt(payment.getCreatedAt());

        return paymentResponse;
    }
}
