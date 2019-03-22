package paulinastapor.booky.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentBookRepository extends JpaRepository<RentBook, Integer> {

    RentBook findFirstByUserEmail(String email);

    RentBook findByBookIdAndUserEmail(Integer id, String email);

}
