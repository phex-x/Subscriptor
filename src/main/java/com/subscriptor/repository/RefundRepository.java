package com.subscriptor.repository;

import com.subscriptor.entity.refund.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, Long> {
}
