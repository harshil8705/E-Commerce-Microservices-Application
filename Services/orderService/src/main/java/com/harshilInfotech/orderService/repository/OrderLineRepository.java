package com.harshilInfotech.orderService.repository;

import com.harshilInfotech.orderService.dto.OrderLineResponse;
import com.harshilInfotech.orderService.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    List<OrderLine> findAllByOrderId(Long orderId);

}