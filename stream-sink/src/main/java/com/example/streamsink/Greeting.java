package com.example.streamsink;

public class Greeting {

    private Integer id;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
