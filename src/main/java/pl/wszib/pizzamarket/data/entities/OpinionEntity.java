package pl.wszib.pizzamarket.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name="opinions")
public class OpinionEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="author_name")
    private String authorName;
    @Column(name="opinion_content")
    private String opinionContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getOpinionContent() {
        return opinionContent;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }
}
