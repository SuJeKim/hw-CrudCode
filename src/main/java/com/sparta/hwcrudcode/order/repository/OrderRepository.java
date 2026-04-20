package com.sparta.hwcrudcode.order.repository;

import com.sparta.hwcrudcode.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
