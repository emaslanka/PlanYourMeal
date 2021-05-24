package pl.coderslab.entity;


import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
    private String ingredients;
    private int timeOfPrep;
    private String linkToRecipe;


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
}
