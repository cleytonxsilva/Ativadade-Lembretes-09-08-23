package Main.main.Service;

import Main.main.Entity.Lembrete;
import Main.main.Repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    public List<Lembrete> findAll() {
        return lembreteRepository.findAll();
    }
}
