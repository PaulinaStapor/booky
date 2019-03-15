package paulinastapor.booky.books;

import lombok.Getter;
import lombok.Setter;
import paulinastapor.booky.users.User;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dateOfPublish;
    private String title;
    private String authorName;
    private String authorSurname;
    private Integer bookBarcode;  //kod kreskowy
    @ManyToOne
    private User user;
}
