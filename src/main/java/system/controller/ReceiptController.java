package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.entity.Receipt;
import system.service.ReceiptService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Receipt> save(@RequestBody @Valid Receipt receipt) {
        return new ResponseEntity<>(receiptService.save(receipt), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Receipt>> getAll() {
        return new ResponseEntity<>(receiptService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Receipt> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(receiptService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        receiptService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
