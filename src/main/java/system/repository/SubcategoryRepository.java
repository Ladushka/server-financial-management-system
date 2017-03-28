package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.entity.Category;
import system.entity.Subcategory;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
List<Subcategory> findByCategory(Category category_id);
}
