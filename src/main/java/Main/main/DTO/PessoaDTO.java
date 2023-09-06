package Main.main.DTO;

import Main.main.Entity.Lembrete;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PessoaDTO{
    private Long id;
    private String nome;
    private List<Lembrete> lembretes;

    public PessoaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public PessoaDTO(){}
}
