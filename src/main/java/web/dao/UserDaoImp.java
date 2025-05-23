package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("FROM User", User.class).getResultList();
   }

   @Override
   public void save(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }

   @Override
   public void delete(Long id) {
      User user = getUserById(id);
      if (user != null) {
         entityManager.remove(user);
      }
   }
}

