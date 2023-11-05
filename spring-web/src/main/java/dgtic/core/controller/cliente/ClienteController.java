package dgtic.core.controller.cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    @GetMapping("/alta-cliente")
    public String paginaAltaCliente(Model model){
        return "cliente/alta-cliente";
    }
}
