package com.project.thismuch.category;

import com.project.thismuch.data.dto.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/allCategories")
    public List<CategoryDTO> getAllCategories(HttpSession session) {
        Long user_no = (Long) session.getAttribute("user_no");

        log.info(String.format("get all categories of user_no: %L", user_no));

        return this.categoryService.findAllCategoriesByUserNo(user_no);
    }
}
