package com.sparta.hwcrudcode.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderRequest {

     @NotNull(message = "상품 아이디는 필수입니다.")
    private Long orderId;

}
