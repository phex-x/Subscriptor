package com.subscriptor.service;

import com.subscriptor.dto.subscription.SubscriptionCreateRequest;
import com.subscriptor.dto.subscription.SubscriptionResponse;
import com.subscriptor.entity.subscription.Subscription;
import com.subscriptor.entity.subscription.SubscriptionStatus;
import com.subscriptor.mapper.SubscriptionMapper;
import com.subscriptor.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionMapper subscriptionMapper;

    public SubscriptionResponse createSubscription(SubscriptionCreateRequest subscriptionCreateRequest) {
        Subscription subscription = subscriptionMapper.toEntity(subscriptionCreateRequest);
        subscription = subscriptionRepository.save(subscription);

        return subscriptionMapper.toResponse(subscription);
    }

    public SubscriptionResponse getSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Subscription not found"));

        return subscriptionMapper.toResponse(subscription);
    }

    public SubscriptionResponse changeSubscriptionStatus(Long id, SubscriptionStatus status) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Subscription not found"));
        subscription.setStatus(status);
        subscription = subscriptionRepository.save(subscription);

        return subscriptionMapper.toResponse(subscription);
    }

    public void deleteSubscription(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Subscription not found"));

        subscriptionRepository.delete(subscription);
    }
}
