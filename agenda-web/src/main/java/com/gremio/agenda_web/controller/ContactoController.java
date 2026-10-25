
package com.gremio.agenda_web.controller;

import com.gremio.agenda_web.model.Contacto;
import com.gremio.agenda_web.repository.ContactoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    // Página principal
    @GetMapping("/")
    public String inicio() {
        return "redirect:/contactos";
    }

    // Mostrar contactos
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    // Formulario nuevo contacto
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // Guardar contacto
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }
}
