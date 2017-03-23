package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Money;
import system.repository.MoneyRepository;

import java.util.List;

@Service("MoneyService")
public class MoneyService {
    @Autowired
    private MoneyRepository moneyRepository;

    public Money save(Money money) {
        return moneyRepository.save(money);
    }

    public Money findOne(Integer money_id) {
        return moneyRepository.findOne(money_id);
    }

    public List<Money> findAll() {
        return moneyRepository.findAll();
    }

    public void delete(Integer money_id) {
        moneyRepository.delete(money_id);
    }

    public Money findByType(String type){ return moneyRepository.findByType(type);}

}
