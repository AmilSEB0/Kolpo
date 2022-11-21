package api.api.Controller;

import api.api.dao.FormDTO;
import api.api.dao.Formdao;
import api.api.form.Form;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
 public class FormController implements InitializingBean {

    public final Formdao formDao;


    @Override
    public void afterPropertiesSet() throws Exception {
        /*
        formDao.save(new Rectangle());
        formDao.save(new Triangle());
        formDao.save(new Cercle());
        formDao.save(new Rectangle(5,3));
        */
        //System.out.println(formDao.findAll());
    }

    public FormController(Formdao formDao) {
        this.formDao = formDao;
    }


     @GetMapping("/formes")
     public List<Form> listDeToutLesFormes(){
         return formDao.findAll();
     }

    @GetMapping("/formes/{id}")
    public Form AfficherUneForme(@PathVariable int id){
        return formDao.findById(id);
    }

    @DeleteMapping(value = "/formes/{id}")
    public void deleteForm(@PathVariable int id){
        formDao.deleteById(id);
    }

    @PostMapping(value = "/formes")
    public  void  addForm( @RequestBody FormDTO form){
        Form forme = FormDTO.toEntity2D(form);
        formDao.saveAndFlush(forme);
    }





}

