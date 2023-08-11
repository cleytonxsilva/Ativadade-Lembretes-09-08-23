package Main.main.DTO;

import Main.main.Entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LembreteDTO {

    private Long id;
    private String mensagem;
    private Pessoa pessoa;
}
