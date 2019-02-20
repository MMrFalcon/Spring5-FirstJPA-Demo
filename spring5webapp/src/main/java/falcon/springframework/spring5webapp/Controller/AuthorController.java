package falcon.springframework.spring5webapp.Controller;

import falcon.springframework.spring5webapp.Repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authorsList", authorRepository.findAll());

        return "authors";
    }
}
