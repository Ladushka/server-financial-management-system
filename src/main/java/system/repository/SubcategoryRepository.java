package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.entity.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
}
