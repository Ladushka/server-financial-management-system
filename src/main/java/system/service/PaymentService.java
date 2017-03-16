package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Payment;
import system.entity.form.PaymentForm;
import system.repository.CategoryRepository;
import system.repository.PaymentRepository;
import system.repository.SubcategoryRepository;

import java.util.List;

@Service("paymentService")
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;
    /*public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }*/

    public Payment findOne(Integer payment_id) {
        return paymentRepository.findOne(payment_id);
    }

    public Payment save(PaymentForm paymentForm) {
        Payment payment = new Payment();
        payment.setPayment_id(paymentForm.getPayment_id());
        payment.setData(paymentForm.getData());
        payment.setCost(paymentForm.getCost());
        payment.setName(paymentForm.getName());
        payment.setCategory(categoryRepository.findOne(paymentForm.getCategory()));
        payment.setSubcategory(subcategoryRepository.findOne(paymentForm.getSubcategory()));

        return paymentRepository.save(payment);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void delete(Integer payment_id) {
        paymentRepository.delete(payment_id);
    }

}
