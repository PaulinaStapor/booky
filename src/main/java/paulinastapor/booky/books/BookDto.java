package paulinastapor.booky.books;

import lombok.Getter;
import lombok.Setter;
import paulinastapor.booky.users.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookDto {
    private String dateOfPublish;
    @NotBlank
    private String title;
    private String authorName;
    @NotBlank
    private String authorSurname;
    @NotNull
    private Integer bookBarcode;  //kod kreskowy
    @ManyToOne
    private User user;
}
