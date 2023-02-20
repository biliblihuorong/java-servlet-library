package cn.edu.czimt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Book {
    private int bookID;
    private String bookName;
    private String author;
    private double price;
    private String publicationDate;
}
