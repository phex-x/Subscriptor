package com.subscriptor.mapper;

import com.subscriptor.dto.subscription.SubscriptionCreateRequest;
import com.subscriptor.dto.subscription.SubscriptionResponse;
import com.subscriptor.entity.subscription.Subscription;
import com.subscriptor.repository.SubscriptionPlanRepository;
import com.subscriptor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SubscriptionPlanRepository planRepository;

    @Autowired
    private PlanMapper planMapper;

    public Subscription toEntity(SubscriptionCreateRequest subscriptionCreateRequest) {
        Subscription subscription = new Subscription();
        subscription.setUser(userRepository.findById(subscriptionCreateRequest.getUserId())
                .orElseThrow(() -> new BadCredentialsException("User not found")));
        subscription.setPlan(planRepository.findById(subscriptionCreateRequest.getPlanId())
                .orElseThrow(() -> new BadCredentialsException("Plan not found")));
        subscription.setStartDate(subscriptionCreateRequest.getStartDate());
        subscription.setEndDate(subscriptionCreateRequest.getEndDate());
        subscription.setAutoRenew(subscriptionCreateRequest.isAutoRenew());

        return subscription;
    }

    public SubscriptionResponse toResponse(Subscription subscription) {
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setId(subscription.getId());
        subscriptionResponse.setUser(userMapper.toResponse(subscription.getUser()));
        subscriptionResponse.setPlan(planMapper.toResponse(subscription.getPlan()));
        subscriptionResponse.setStatus(subscription.getStatus());
        subscriptionResponse.setStartDate(subscription.getStartDate());
        subscriptionResponse.setEndDate(subscription.getEndDate());
        subscriptionResponse.setAutoRenew(subscription.isAutoRenew());

        return subscriptionResponse;
    }
}
