package com.example.demo.controller;

import com.example.demo.model.Habilidade;
import com.example.demo.model.Projeto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Year;
import java.util.List;

@Controller
public class HomeController {

    // Rota principal: envia os dados do portfólio para o Thymeleaf
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nome", "João Henrique Alves de Souza");
        model.addAttribute("titulo", "Estudante de Sistemas de Informação | Desenvolvedor Java");
        model.addAttribute("sobre", "Sou estudante de Sistemas de Informação na Universidade de Mogi das Cruzes (UMC). "
                + "Trabalho durante o dia e estudo à noite, e venho me dedicando ao desenvolvimento web, "
                + "praticando tanto o back-end, quanto o front-end. Gosto de transformar o que aprendo "
                + "em sala em projetos práticos.");
        model.addAttribute("universidade", "Universidade de Mogi das Cruzes (UMC)");
        model.addAttribute("curso", "Bacharelado em Sistemas de Informação");
        model.addAttribute("email", "jhalvesdesouza@gmail.com");
        model.addAttribute("anoAtual", Year.now().getValue());

        List<Habilidade> habilidades = List.of(
                new Habilidade("Back-end", List.of("Java", "Spring Boot", "Python", "Flask")),
                new Habilidade("Front-end", List.of("HTML5", "CSS3", "JavaScript", "Thymeleaf", "Bootstrap")),
                new Habilidade("Banco de dados", List.of("PostgreSQL", "SQL", "Flyway")),
                new Habilidade("Ferramentas", List.of("Git", "GitHub", "Postman", "IntelliJ IDEA"))
        );
        model.addAttribute("habilidades", habilidades);

        List<Projeto> projetos = List.of(
                new Projeto("SafeClick",
                        "Projeto Final de Curso: plataforma web de educação em segurança digital "
                                + "(\"Aprenda antes de clicar\"), com conteúdos educativos, quizzes e simulações de golpes.",
                        "Web",
                        List.of("Python", "Flask", "PostgreSQL", "Bootstrap"),
                        "https://github.com/EduMafra10/SafeClick"),
                new Projeto("Portfólio com Spring Boot",
                        "Este site: aplicação Spring Boot com Thymeleaf, em que o Controller envia os dados "
                                + "do portfólio para a página pelo Model.",
                        "Java",
                        List.of("Java", "Spring Boot", "Thymeleaf"),
                        null),
                new Projeto("API com Spring Boot",
                        "Atividades da disciplina Java Spring Fundamentals: API com Spring Boot, "
                                + "banco PostgreSQL, migrações com Flyway e testes no Postman.",
                        "Java",
                        List.of("Java", "Spring Boot", "PostgreSQL", "Flyway"),
                        null),
                new Projeto("Feriados Nacionais",
                        "Página que consulta a BrasilAPI e mostra os feriados do ano em uma tabela, "
                                + "destacando os fins de semana e o próximo feriado.",
                        "Front-end",
                        List.of("HTML", "CSS", "JavaScript", "API"),
                        null),
                new Projeto("Inscrição em Evento",
                        "Formulário com estados e cidades carregados da API do IBGE, "
                                + "com requisições encadeadas e filtro de cidades.",
                        "Front-end",
                        List.of("HTML", "CSS", "JavaScript", "API"),
                        null)
        );
        model.addAttribute("projetos", projetos);

        return "index"; // procura por templates/index.html
    }

    // Rota do formulário de contato: recebe os dados enviados pela página
    @PostMapping("/contato")
    public String contato(@RequestParam("nome") String nome,
                          @RequestParam("email") String email,
                          @RequestParam("mensagem") String mensagem,
                          RedirectAttributes redirectAttributes) {

        System.out.println("Nova mensagem de " + nome + " (" + email + "): " + mensagem);

        redirectAttributes.addFlashAttribute("mensagemSucesso",
                "Obrigado, " + nome + "! Sua mensagem foi enviada com sucesso.");

        return "redirect:/#contato";
    }
}
