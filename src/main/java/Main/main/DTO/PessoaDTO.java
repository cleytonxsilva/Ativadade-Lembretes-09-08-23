package Main.main.DTO;

import Main.main.Entity.Lembrete;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PessoaDTO{
    private Long id;
    private String nome;
    private List<Lembrete> lembretes;
}
