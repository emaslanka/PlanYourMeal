package pl.coderslab.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=100)
    private String name;

    @NotNull
    @ManyToOne
    private Category category;

    @Size(max=600)
    private String ingredients;

    @NotNull
    @Min(5)
    @Max(1000)
    private int timeOfPrep;

    private String linkToRecipe;

    @ManyToMany(mappedBy = "meals")
    private List<Plan> plans = new ArrayList<>();


    public Meal(Long id, String name, Category category, String ingredients, int timeOfPrep, String linkToRecipe) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.timeOfPrep = timeOfPrep;
        this.linkToRecipe = linkToRecipe;
    }

    public Meal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getTimeOfPrep() {
        return timeOfPrep;
    }

    public void setTimeOfPrep(int timeOfPrep) {
        this.timeOfPrep = timeOfPrep;
    }

    public String getLinkToRecipe() {
        return linkToRecipe;
    }

    public void setLinkToRecipe(String linkToRecipe) {
        this.linkToRecipe = linkToRecipe;
    }

    @Override
    public String toString() {
        return name;
    }


}
