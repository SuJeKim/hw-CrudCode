package com.sparta.hwcrudcode.order.service;


import com.sparta.hwcrudcode.order.dto.OrderRequest;
import com.sparta.hwcrudcode.order.dto.OrderResponse;
import com.sparta.hwcrudcode.order.entity.Order;
import com.sparta.hwcrudcode.order.repository.OrderRepository;
import com.sparta.hwcrudcode.product.entity.Product;
import com.sparta.hwcrudcode.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse createProduct(OrderRequest request) {
        Product product = findProductById(request.getOrderId());
        Order order = new Order(product);
        Order saved = orderRepository.save(order);
        return new OrderResponse(saved);
    }


    public @Nullable OrderResponse getOrder(Long id) {
        Order order = findById(id);
        return new OrderResponse(order);
    }

    private Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다. id=" + id));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + id));
    }
}
