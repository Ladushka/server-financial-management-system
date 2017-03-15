package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.entity.Money;

public interface MoneyRepository extends JpaRepository<Money, Integer> {
}
