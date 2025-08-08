package com.wipro.item;

import org.springframework.stereotype.Component;

@Component
public class category {
    private int categoryId;
    private String categoryName;

    public category() {
        this.categoryId = 1001;
        this.categoryName = "Electronics Category";
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
