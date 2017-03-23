package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.entity.Money;
import system.service.MoneyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Money> save(@RequestBody @Valid Money money) {
        return new ResponseEntity<>(moneyService.save(money), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Money>> getAll() {
        return new ResponseEntity<>(moneyService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Money> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(moneyService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        moneyService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public ResponseEntity<Money> get(@PathVariable("type") String type) {
        return new ResponseEntity<>(moneyService.findByType(type), HttpStatus.OK);
    }
}
