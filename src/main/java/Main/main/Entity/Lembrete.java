package Main.main.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lembrete", schema = "private")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mensagem;
    @ManyToOne
    @JoinColumn(name = "fk_pessoa")
    @JsonBackReference
    private Pessoa pessoa;
}

