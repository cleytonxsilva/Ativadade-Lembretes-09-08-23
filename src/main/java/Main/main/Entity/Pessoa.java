package Main.main.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "pessoa", schema = "private")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pessoa")
    @JsonManagedReference
    private List<Lembrete>lembretes;

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Pessoa(String nome, List<Lembrete> lembretes) {
        this.nome = nome;
        this.lembretes = lembretes;
    }

    public Pessoa() {

    }
}
