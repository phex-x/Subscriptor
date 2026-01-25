package com.subscriptor.repository;

import com.subscriptor.entity.payment.Payment;
import com.subscriptor.entity.refund.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefundRepository extends JpaRepository<Refund, Long> {
    Optional<Refund> findByPayment(Payment payment);
}
