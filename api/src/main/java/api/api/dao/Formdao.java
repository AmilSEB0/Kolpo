package api.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.api.form.Form;

@Repository
public interface Formdao extends JpaRepository<Form, Integer> {
    Form findById(int id);
    // Form findAll();

}
