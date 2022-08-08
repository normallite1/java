package ua.kostia.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kostia.social.model.User;

public interface UserRepository extends JpaRepository<User,Long> {


}
