/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service;

import com.huyhung.pojo.OrderTicket;

/**
 *
 * @author TIM
 */
public interface OrderService {
    boolean createOrder(OrderTicket order);
}
