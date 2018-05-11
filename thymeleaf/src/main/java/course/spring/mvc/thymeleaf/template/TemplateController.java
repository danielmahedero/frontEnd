package course.spring.mvc.thymeleaf.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TemplateController {

    @GetMapping("/")
    public String main() {
        return "home";
    }


    @GetMapping("/iterations")
    public String iterations(ModelMap modelMap) {
        modelMap.addAttribute("userForm", new UserForm());
        return "iterations";
    }


    @PostMapping("/iterations")
    public String iterations(@ModelAttribute("userForm") UserForm userForm, ModelMap modelMap) {

        List<User> users = Arrays.asList(
                new User(1L, "User 1", "user1@domain"),
                new User(2L, "User 2", "user2@domain"),
                new User(3L, "User 3", "user3@domain")

        );


        if (userForm.getQ() != null) {
            users = users.stream().filter(
                        p -> p.getEmail().contains(userForm.getQ()) ||
                        p.getName().contains(userForm.getQ()))
                    .collect(Collectors.toList());
        }


        modelMap.addAttribute("users", users);
        modelMap.addAttribute("userForm", userForm);


        return "iterations";
    }
}
