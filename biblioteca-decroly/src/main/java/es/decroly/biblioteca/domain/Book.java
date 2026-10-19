package es.decroly.biblioteca.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {


    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Integer publicationYear;
    private int copies;
    private int available;
    private Long categoryId;

}
