 package api.api.dao;

 import api.api.form.ListForm;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public interface Listformdao extends JpaRepository<ListForm, Integer> {

}



