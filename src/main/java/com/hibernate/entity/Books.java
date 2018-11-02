package com.hibernate.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books",catalog="orange")
public class Books
{
    private String title;
    private String isbn;
    @Id
    @Column(name="Title")
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    @Column(name="ISBN")
    public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String isbn)
    {
        this.isbn=isbn;
    }
}
