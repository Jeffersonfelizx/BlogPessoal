package com.generation.BlogPessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.BlogPessoal.repository.PostagemRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name ="tb_tema" )
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Não pode ser nulo!")
    @Size(min =50 ,max = 500, message = "Deve conter entre min: 50 e max: 500")
    @Column(length = 500)
    private String descricao;

@OneToMany(fetch = FetchType.LAZY,mappedBy = "tema",cascade = CascadeType.REMOVE)
@JsonIgnoreProperties("tema")
private List<Postagem> postagem;

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
