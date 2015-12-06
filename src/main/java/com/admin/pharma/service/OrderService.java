package com.admin.pharma.service;

import com.admin.pharma.model.Medicine;

/**
 * Created by DELL on 12/3/2015.
 */
public interface OrderService {
    int bookOrder(Medicine med,int quantity);
}
