package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.entity.Subcategory;
import system.entity.form.SubcategoryForm;
import system.service.SubcategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/subcategories")
public class SubcategoryController {
    @Autowired
    private SubcategoryService subcategoryService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Subcategory> save(@RequestBody @Valid SubcategoryForm subcategory) {
        return new ResponseEntity<>(subcategoryService.save(subcategory), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Subcategory>> getAll() {
        return new ResponseEntity<>(subcategoryService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subcategory> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(subcategoryService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        subcategoryService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
