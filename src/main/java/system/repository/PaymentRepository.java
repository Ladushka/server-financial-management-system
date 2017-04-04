package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import system.entity.Category;
import system.entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByCategory(Category category_id);

    @Query(value = "SELECT * FROM payment p WHERE MONTH(p.data) = (:month)", nativeQuery = true)
    List<Payment> findPaymentsByMonth(@Param("month") Integer month);

    @Query(value = "SELECT * FROM payment p WHERE MONTH(p.data) = (:month) and p.id_category = :category_id", nativeQuery = true)
    List<Payment> findPaymentsByMonthAndCategory(@Param("month") Integer month, @Param("category_id") Integer category_id);
}
