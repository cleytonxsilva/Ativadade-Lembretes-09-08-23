package Main.main.Repository;

import Main.main.Entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    List<Lembrete> findByPessoaId(Long id);
}
