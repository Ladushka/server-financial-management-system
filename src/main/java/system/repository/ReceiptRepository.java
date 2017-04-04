package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import system.entity.Receipt;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    @Query(value = "SELECT * FROM receipt r WHERE MONTH(r.data) = (:month)", nativeQuery = true)
    List<Receipt> findReceiptsByMonth(@Param("month") Integer month);
}
