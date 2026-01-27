package com.subscriptor.mapper;

import com.subscriptor.dto.subscriptionPlan.PlanCreateRequest;
import com.subscriptor.dto.subscriptionPlan.PlanResponse;
import com.subscriptor.entity.SubscriptionPlan;
import org.springframework.stereotype.Component;

@Component
public class PlanMapper {

    public SubscriptionPlan toEntity(PlanCreateRequest planCreateRequest) {
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        subscriptionPlan.setName(planCreateRequest.getName());
        subscriptionPlan.setDescription(planCreateRequest.getDescription());
        subscriptionPlan.setPrice(planCreateRequest.getPrice());
        subscriptionPlan.setCurrency(planCreateRequest.getCurrency());
        subscriptionPlan.setDurationDays(planCreateRequest.getDurationDays());
        subscriptionPlan.setIsRecurring(planCreateRequest.isRecurring());
        subscriptionPlan.setTrialDays(planCreateRequest.getTrialDays());

        return subscriptionPlan;
    }

    public PlanResponse toResponse(SubscriptionPlan subscriptionPlan) {
        PlanResponse planResponse = new PlanResponse();
        planResponse.setName(subscriptionPlan.getName());
        planResponse.setDescription(subscriptionPlan.getDescription());
        planResponse.setPrice(subscriptionPlan.getPrice());
        planResponse.setCurrency(subscriptionPlan.getCurrency());
        planResponse.setDurationDays(subscriptionPlan.getDurationDays());
        planResponse.setRecurring(subscriptionPlan.getIsRecurring());
        planResponse.setTrialDays(subscriptionPlan.getTrialDays());

        return planResponse;
    }
}
