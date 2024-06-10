package br.com.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscristos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscristos() {
        return conteudosInscristos;
    }

    public void setConteudosInscristos(Set<Conteudo> conteudosInscristos) {
        this.conteudosInscristos = conteudosInscristos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscristos.addAll(bootcamp.getConteudos());
        bootcamp.getDevInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscristos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscristos.remove(conteudo.get());
        }else{
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXP(){
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public void exibirDadosDev() {
        if(!conteudosInscristos.isEmpty()){
            System.out.println("Dados do dev: " + getNome());
            System.out.println("Conteúdos inscritos:");
            for(Conteudo conteudo : conteudosInscristos){
                System.out.println(conteudo.getTitulo());
                System.out.println(conteudo.getDescricao());
            }
        }else{
            System.out.println("Você não está inscrito em nenhum curso!");
        }

        if(!conteudosConcluidos.isEmpty()){
            System.out.println("Conteúdos concluídos:");
            for(Conteudo conteudo : conteudosConcluidos){
                System.out.println(conteudo.getTitulo());
            }
        }else{
            System.out.println("Você não concluiu o conteúdo!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosInscristos(), dev.getConteudosInscristos()) && Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosInscristos(), getConteudosConcluidos());
    }
}
