package paulinastapor.booky.rent;

import lombok.Getter;
import lombok.Setter;
import paulinastapor.booky.books.Book;
import paulinastapor.booky.users.User;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class RentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Temporal(TemporalType.DATE)
    public Date dateFrom;
    @Temporal(TemporalType.DATE)
    public Date dateTo;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
}
