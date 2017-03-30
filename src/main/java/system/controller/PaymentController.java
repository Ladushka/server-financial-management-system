package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.entity.Payment;
import system.entity.Subcategory;
import system.entity.form.PaymentForm;
import system.service.PaymentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Payment> save(@RequestBody @Valid PaymentForm payment) {
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAll() {
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(paymentService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        paymentService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{category_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getByGroup(@PathVariable("category_id") Integer category_id) {
        return new ResponseEntity<>(paymentService.findByCategory(category_id), HttpStatus.OK);
    }

//    @RequestMapping(value = "/month/{month}", method = RequestMethod.GET)
//    public ResponseEntity<List<Payment>> getPaymentsByMonth(@PathVariable("month") Integer month) {
//        return new ResponseEntity<>(paymentService.findPaymentsByMonth(month), HttpStatus.OK);
//    }
}
