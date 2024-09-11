package atl.classroom.task.crud.controller;

import atl.classroom.task.crud.feign.CategoryFeign;
import atl.classroom.task.crud.model.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryFeign categoryFeign;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(categoryFeign.getCategoryById(id));
    }
}
