package com.tedu.java.service.impl;

import com.tedu.java.dao.PaymentDao;
import com.tedu.java.pojo.Payment;
import com.tedu.java.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： zyy
 * @date： 2022/9/18 16:14
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
