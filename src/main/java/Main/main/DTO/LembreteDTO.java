package Main.main.DTO;

import Main.main.Entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LembreteDTO {

    private Long id;
    private String mensagem;
    private PessoaDTO pessoa;

    public LembreteDTO(Long id, String mensagem, PessoaDTO pessoa) {
        this.id = id;
        this.mensagem = mensagem;
        this.pessoa = pessoa;
    }
    public LembreteDTO(){}
}
