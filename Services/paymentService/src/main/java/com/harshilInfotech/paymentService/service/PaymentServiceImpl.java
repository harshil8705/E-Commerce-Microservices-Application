package com.harshilInfotech.paymentService.service;

import com.harshilInfotech.paymentService.dto.PaymentNotificationRequest;
import com.harshilInfotech.paymentService.dto.PaymentRequest;
import com.harshilInfotech.paymentService.mapper.PaymentMapper;
import com.harshilInfotech.paymentService.notification.NotificationProducer;
import com.harshilInfotech.paymentService.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Long createPayment(PaymentRequest request) {

        var payment = paymentRepository.save(paymentMapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();

    }
}