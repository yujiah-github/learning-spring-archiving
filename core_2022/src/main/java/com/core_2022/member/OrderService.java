package com.core_2022.member;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
