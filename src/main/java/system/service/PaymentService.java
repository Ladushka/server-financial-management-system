package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Payment;
import system.repository.PaymentRepository;

import java.util.List;

@Service("paymentService")
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment findOne(Integer payment_id) {
        return paymentRepository.findOne(payment_id);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void delete(Integer payment_id) {
        paymentRepository.delete(payment_id);
    }

}
