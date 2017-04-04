package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Receipt;
import system.repository.ReceiptRepository;

import java.util.List;

@Service("receiptService")
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    public Receipt save(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public Receipt findOne(Integer receipt_id) {
        return receiptRepository.findOne(receipt_id);
    }

    public List<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    public void delete(Integer receipt_id) {
        receiptRepository.delete(receipt_id);
    }

    public List<Receipt> findReceiptsByMonth(Integer month) {
        return receiptRepository.findReceiptsByMonth(month);
    }
}
