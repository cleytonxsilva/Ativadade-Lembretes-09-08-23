package Main.main.Controller;

import Main.main.Entity.Lembrete;
import Main.main.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;
//    @GetMapping
//    public ResponseEntity<List<Lembrete>> findAll(){
//        try{
//            return ResponseEntity.ok(lembreteService.findAll());
//        }catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Lembrete lembrete){
        try{
            lembreteService.cadastrar(lembrete);
            return ResponseEntity.ok("Lembrete cadastrado com sucesso!");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
