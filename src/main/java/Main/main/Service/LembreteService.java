package Main.main.Service;

import Main.main.Entity.Lembrete;
import Main.main.Repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    public void cadastrar(Lembrete lembrete) {

        try{
            lembreteRepository.save(lembrete);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error");
        }
    }

//    public List<Lembrete> findAll() {
//        return lembreteRepository.findAll();
//    }
}
