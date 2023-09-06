package Main.main.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lembrete", schema = "private")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "mensagem", nullable = false, length = 250)
    private String mensagem;
    @ManyToOne
    @JoinColumn(name = "fk_pessoa", nullable = false)
    @JsonBackReference
    private Pessoa pessoa;

    public Lembrete() {
    }

    public Lembrete(Long id, String mensagem, Pessoa pessoa) {
        this.id = id;
        this.mensagem = mensagem;
        this.pessoa = pessoa;
    }
}

