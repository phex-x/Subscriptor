package com.subscriptor.service;

import com.subscriptor.dto.subscriptionPlan.PlanCreateRequest;
import com.subscriptor.dto.subscriptionPlan.PlanResponse;
import com.subscriptor.entity.SubscriptionPlan;
import com.subscriptor.mapper.PlanMapper;
import com.subscriptor.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Autowired
    private PlanMapper planMapper;

    public PlanResponse createPlan(PlanCreateRequest planCreateRequest) {
        if (subscriptionPlanRepository.findByName(planCreateRequest.getName()).isPresent()) {
            throw new BadCredentialsException("Plan already exists");
        }

        SubscriptionPlan plan = planMapper.toEntity(planCreateRequest);
        plan = subscriptionPlanRepository.save(plan);

        return planMapper.toResponse(plan);
    }

    public PlanResponse getPlanById(Long id) {
        SubscriptionPlan plan = subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Plan not found"));

        return planMapper.toResponse(plan);
    }

    public void delete(Long id) {
        SubscriptionPlan plan = subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Plan not found"));

        subscriptionPlanRepository.delete(plan);
    }
}
