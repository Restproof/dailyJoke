package be.tftic.models;


import java.io.Serializable;

public class Blague implements Serializable {
    private long id;
    private String jokeContent;
    private String category;

    public Blague (String jokeContent, String category) {
        this.id = Identifier.IdCounter++;
        this.jokeContent = jokeContent;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getJokeContent() {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent) {
        this.jokeContent = jokeContent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
