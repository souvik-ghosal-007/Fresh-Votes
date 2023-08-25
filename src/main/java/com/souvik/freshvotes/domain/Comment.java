package com.souvik.freshvotes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
@Embeddable
public class Comment {

    @EmbeddedId
    private CommentId pk;

    @Column(length = 5000)
    private String text;

    public CommentId getPk() {
        return pk;
    }

    public void setPk(CommentId pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
