package codegym.c0623k1.md3_casestudy_walletonline.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Money {
    private User user;
    private CategoryDetail categoryDetail;
    private String description;

    private float money;

    private LocalDateTime date;

    public Money() {
    }

    public Money(User user, CategoryDetail categoryDetail, String description, float money) {
        this.user = user;
        this.categoryDetail = categoryDetail;
        this.description = description;
        this.money = money;
    }
    public Money(User user, CategoryDetail categoryDetail, String description, float money, LocalDateTime date) {
        this.user = user;
        this.categoryDetail = categoryDetail;
        this.description = description;
        this.money = money;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CategoryDetail getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(CategoryDetail categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
