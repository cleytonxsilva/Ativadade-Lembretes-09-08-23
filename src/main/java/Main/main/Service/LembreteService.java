package Main.main.Service;

import Main.main.DTO.LembreteDTO;
import Main.main.Entity.Lembrete;
import Main.main.Repository.LembreteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private PessoaService pessoaService;

    public Lembrete findById(final Long id) {
        return this.lembreteRepository.findById(id).orElseThrow();
    }

    public List<Lembrete> findAll() {
        return this.lembreteRepository.findAll();
    }

    public List<Lembrete> findAllOfPessoa(final String nome) {
        return this.lembreteRepository.findByPessoa(pessoaService.findByName(nome).getId());
    }

    @Transactional
    public void create(LembreteDTO lembreteDTO) {
        Assert.isTrue(!lembreteDTO.getMensagem().isBlank(), "Mensagem não pode ser nula!");
        Assert.notNull(lembreteDTO.getPessoa(), "Lembrete deve ser vinculado a uma pessoa!");

        lembreteRepository.save(this.toLembrete(lembreteDTO));
    }

    @Transactional
    public void update(Long id, LembreteDTO lembreteDTO) {
        LembreteDTO lembreteDatabase = toLembreteDTO(findById(id));
        Assert.notNull(lembreteDatabase, "Lembrete não encontrado!");
        Assert.isTrue(lembreteDatabase.getId().equals(lembreteDTO.getId()), "Lembretes não conferem!");
        Assert.isTrue(!lembreteDTO.getMensagem().isBlank(), "Mensagem não pode ser nula!");
        Assert.notNull(lembreteDTO.getPessoa(), "Lembrete deve ser vinculado a uma pessoa!");

        lembreteRepository.save(toLembrete(lembreteDTO));
    }

    @Transactional
    public void delete(Long id) {
        LembreteDTO lembreteDTO = toLembreteDTO(findById(id));
        Assert.notNull(lembreteDTO, "Lembrete não encontrado!");

        lembreteRepository.delete(toLembrete(lembreteDTO));
    }

    public Lembrete toLembrete(LembreteDTO lembreteDTO) {
        return new Lembrete(lembreteDTO.getId(), lembreteDTO.getMensagem(), pessoaService.toPessoa(lembreteDTO.getPessoa()));
    }

    public LembreteDTO toLembreteDTO(Lembrete lembrete) {
        return new LembreteDTO(lembrete.getId(), lembrete.getMensagem(), pessoaService.toPessoaDTO(lembrete.getPessoa()));
    }
}
