package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Subcategory;
import system.repository.SubcategoryRepository;

import java.util.List;

@Service("subcategoryService")
public class SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public Subcategory save(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory findOne(Integer subcategory_id) {
        return subcategoryRepository.findOne(subcategory_id);
    }

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    public void delete(Integer subcategory_id) {
        subcategoryRepository.delete(subcategory_id);
    }

}
