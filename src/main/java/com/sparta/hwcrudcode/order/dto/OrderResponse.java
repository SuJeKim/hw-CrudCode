package com.sparta.hwcrudcode.order.dto;

import com.sparta.hwcrudcode.order.entity.Order;
import lombok.Getter;

@Getter
public class OrderResponse {

    private final Long id;           // 주문 ID
    private final String productName; // 상품 이름 (Order -> Product -> Name)
    private final Integer price;     // 상품 가격 (Order -> Product -> Price)

    public OrderResponse(Order order) {
        this.id = order.getId();
        // 연관된 Product 엔티티에서 데이터를 꺼내와서 DTO 필드
        this.productName = order.getProduct().getName();
        this.price = order.getProduct().getPrice();
    }
}
