package atl.classroom.task.crud.feign;

import atl.classroom.task.crud.model.response.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-feign", url = "http://localhost:8080/api/v1/categories")
public interface CategoryFeign {
    @GetMapping("/{id}")
    CategoryResponse getCategoryById(@PathVariable Long id);
}
