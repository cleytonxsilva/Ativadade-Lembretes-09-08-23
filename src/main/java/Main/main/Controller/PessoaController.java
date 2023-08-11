package Main.main.Controller;


import Main.main.Entity.Pessoa;
import Main.main.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity <List<Pessoa>> findAll(){
        try{
            return ResponseEntity.ok(pessoaService.findAll());
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Erro ao consultar a lista!", e);
        }
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Pessoa pessoa){
        try{
            pessoaService.cadastrar(pessoa);
            return ResponseEntity.ok("Pessoa cadastrada com sucesso!");
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Erro ao cadastrar no banco", e);
        }
    }
}
