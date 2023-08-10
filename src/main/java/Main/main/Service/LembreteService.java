package Main.main.Service;

import Main.main.Repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;
}
