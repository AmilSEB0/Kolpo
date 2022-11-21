package api.api.Controller;

import api.api.dao.Listformdao;
import api.api.form.ListForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
public class ListController {

    private final Listformdao listformdao;

    public ListController(Listformdao Listformdao) {
        this.listformdao = Listformdao;
    }

    @PostMapping(value = "/list")
    public ListForm addList(@RequestBody ListForm ListForm){
        return listformdao.save(ListForm);

    }


    @GetMapping("/list")
    public List<ListForm> listDesFormes(){
        return listformdao.findAll();

    }

    @GetMapping("/list/{id}")
    public Optional<ListForm> AfficherUneForme(@PathVariable int id){
        return listformdao.findById(id);
    }

    @DeleteMapping(value = "/list/{id}")
    public void deleteForm(@PathVariable int id){
        listformdao.deleteById(id);
    }


}
