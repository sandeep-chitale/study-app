package com.admin.pharma.serviceImpl;

import com.admin.pharma.model.Medicine;
import com.admin.pharma.service.OrderService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DELL on 12/3/2015.
 */
public class OrderServiceImpl implements OrderService {
    public static void main(String[] args) {
        final OrderServiceImpl orderService = new OrderServiceImpl();
        final Medicine m1 = new Medicine();
        m1.drugID ="m1";
        for(int i=0;i<500;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"-> "+orderService.bookOrder(m1,6));
                }
            }).start();
        }
    }
    //<Medicine,Qty>
    private Map<Medicine,AtomicInteger> medicineQty = new ConcurrentHashMap<>();
    private OrderServiceImpl(){
        Medicine m1 = new Medicine();
        m1.drugID ="m1"; m1.contents.put("c1",10.0);
        Medicine m2 = new Medicine();
        m2.drugID ="m2"; m2.contents.put("c1",10.0);

        medicineQty.put(m1,new AtomicInteger(1000));
        medicineQty.put(m2,new AtomicInteger(1000));
    }
    @Override
    public int bookOrder(Medicine med, int quantity) {
        if(!medicineQty.containsKey(med) || medicineQty.get(med).get() <= 0) return 0;

        int remainingQty = 0;

        AtomicInteger medQty = medicineQty.get(med);

        if(medQty.get() > 0){
            remainingQty = medQty.addAndGet(-quantity);
            if(remainingQty >= 0) return quantity;
        }else return 0;

        if(remainingQty< 0)
            medQty.set(0);

        return (quantity+remainingQty) <0 ? 0 : (quantity+remainingQty);
    }
}
