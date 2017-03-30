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
    //public List<Person> find(@Param("lastName") String lastName);
}
