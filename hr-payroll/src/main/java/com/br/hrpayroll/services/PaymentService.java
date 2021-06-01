package com.br.hrpayroll.services;

import com.br.hrpayroll.entities.Payment;
import com.br.hrpayroll.entities.Worker;
import com.br.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId,int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(),worker.getDailyIncome(),days);

    }
}
