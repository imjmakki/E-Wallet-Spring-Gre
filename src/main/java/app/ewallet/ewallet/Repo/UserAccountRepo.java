package app.ewallet.ewallet.Repo;

import app.ewallet.ewallet.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Integer>{

    UserAccount findByEmail(String email);

    UserAccount findByPhoneNumber(String phoneNumber);

    UserAccount findById(String id);

}
