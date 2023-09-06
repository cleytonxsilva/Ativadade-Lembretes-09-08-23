package Main.main.Service;


import Main.main.DTO.PessoaDTO;
import Main.main.Entity.Pessoa;
import Main.main.Repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
            return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return this.pessoaRepository.findById(id).orElseThrow();
    }

    public Pessoa findByName(String nome) {
        return this.pessoaRepository.findByName(nome);
    }

    @Transactional
    public void create(PessoaDTO pessoaDTO) {
        Assert.isTrue(!pessoaDTO.getNome().isBlank(), "Nome não pode ser nulo!");

        pessoaRepository.save(this.toPessoa(pessoaDTO));
    }

    @Transactional
    public void update(Long id, PessoaDTO pessoaDTO) {
        PessoaDTO pessoaDatabase = toPessoaDTO(findById(id));
        Assert.notNull(pessoaDatabase, "Pessoa não encontrado!");
        Assert.isTrue(pessoaDatabase.getId().equals(pessoaDTO.getId()), "Pessoas não conferem!");
        Assert.isTrue(!pessoaDTO.getNome().isBlank(), "Nome não pode ser nulo!");

        pessoaRepository.save(toPessoa(pessoaDTO));
    }

    @Transactional
    public void delete(Long id) {
        PessoaDTO pessoaDTO = toPessoaDTO(findById(id));
        Assert.notNull(pessoaDTO, "Pessoa não encontrada!");

        pessoaRepository.delete(toPessoa(pessoaDTO));
    }

    public Pessoa toPessoa(PessoaDTO pessoaDTO) {
        return new Pessoa(pessoaDTO.getId(), pessoaDTO.getNome());
    }

    public PessoaDTO toPessoaDTO(Pessoa pessoa) {
        return new PessoaDTO(pessoa.getId(), pessoa.getNome());
    }
}
