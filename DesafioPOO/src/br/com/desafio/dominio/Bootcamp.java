package br.com.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dateInicial = LocalDate.now();
    private final LocalDate dataFinal = dateInicial.plusDays(45);
    private Set<Dev> devInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDateInicial() {
        return dateInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevInscritos() {
        return devInscritos;
    }

    public void setDevInscritos(Set<Dev> devInscritos) {
        this.devInscritos = devInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public void exibirAlunosBootcamp() {
        System.out.println("Alunos inscritos no bootcamp");
        if(!getDevInscritos().isEmpty()){
            for(Dev dev : devInscritos){
                System.out.println(dev.getNome());
            }
        }else{
            System.out.println("Não há devs inscritos nesse bootcamp!");
        }
    }

    public void exibirCursosBootcamp() {
        System.out.println("Cursos do bootcamp");
        if(!getConteudos().isEmpty()){
            for(Conteudo conteudo : conteudos){
                if(conteudo instanceof Curso){
                    System.out.println(conteudo.getTitulo());
                }
            }
        }else{
            System.out.println("Não há cursos nesse bootcamp!");
        }
    }

    public void removerDevNome(String nome) {
        if(!getDevInscritos().isEmpty()){
            for(Dev dev : devInscritos){
                if(dev.getNome().equalsIgnoreCase(nome)){
                    devInscritos.remove(dev);
                }
            }
        }else{
            System.out.println("Não há devs inscritos nesse bootcamp!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp bootcamp)) return false;
        return Objects.equals(getNome(), bootcamp.getNome()) && Objects.equals(getDescricao(), bootcamp.getDescricao()) && Objects.equals(getDateInicial(), bootcamp.getDateInicial()) && Objects.equals(getDataFinal(), bootcamp.getDataFinal()) && Objects.equals(getDevInscritos(), bootcamp.getDevInscritos()) && Objects.equals(getConteudos(), bootcamp.getConteudos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDescricao(), getDateInicial(), getDataFinal(), getDevInscritos(), getConteudos());
    }
}
