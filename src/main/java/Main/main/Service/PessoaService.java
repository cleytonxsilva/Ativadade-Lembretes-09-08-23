package Main.main.Service;


import Main.main.Entity.Pessoa;
import Main.main.Repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
            return pessoaRepository.findAll();
    }

    @Transactional
    public void cadastrar(Pessoa pessoa) {

        try{
            pessoaRepository.save(pessoa);
        }catch (DataIntegrityViolationException  e){
            throw new RuntimeException (e) {
            };
        }
    }
}
