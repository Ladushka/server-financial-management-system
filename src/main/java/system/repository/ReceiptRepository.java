package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
