import br.com.desafio.dominio.Bootcamp;
import br.com.desafio.dominio.Curso;
import br.com.desafio.dominio.Dev;
import br.com.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Pilares POO");
        curso1.setDescricao("Descrição: curso pilares POO");
        curso1.setCargaHoraria(3);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição: curso JS");
        curso2.setCargaHoraria(5);

        Curso curso3 = new Curso();
        curso3.setTitulo("Curso Collections");
        curso3.setDescricao("Descrição: curso Collections");
        curso3.setCargaHoraria(6);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Descrição: mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição: Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devEduardo = new Dev();
        devEduardo.setNome("Eduardo");
        devEduardo.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos de Eduardo: " + devEduardo.getConteudosInscristos());
        devEduardo.progredir();
        System.out.println("-------");
        System.out.println("Conteúdos Inscritos de Eduardo: " + devEduardo.getConteudosInscristos());
        System.out.println("Conteúdos Concluidos de Eduardo: " + devEduardo.getConteudosConcluidos());
        System.out.println("XP: " + devEduardo.calcularTotalXP());

        System.out.println("\n-------------------------------------\n");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos de João: " + devJoao.getConteudosInscristos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-------");
        System.out.println("Conteúdos Inscritos de João: " + devJoao.getConteudosInscristos());
        System.out.println("Conteúdos Concluidos de João: " + devJoao.getConteudosConcluidos());
        System.out.println("XP: " + devJoao.calcularTotalXP());

    }
}