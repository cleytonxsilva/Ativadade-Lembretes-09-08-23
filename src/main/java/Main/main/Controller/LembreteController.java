package Main.main.Controller;

import Main.main.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;
}
