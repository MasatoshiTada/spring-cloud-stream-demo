package com.example.streamsource;

public class Greeting {

    private Integer id;

    private String text;

    public Greeting(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
