package br.edu.unifacef.bdrestful.controller;

import br.edu.unifacef.bdrestful.model.Formulario;
import br.edu.unifacef.bdrestful.service.FormularioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulario")
public class FormularioController {
    // injeção de dependência
    FormularioService formularioService;
    public FormularioController(FormularioService formularioService){
        this.formularioService = formularioService;
    }

    // consulta
    @GetMapping
    public List<Formulario> getFormularios(){
        return formularioService.getFormularios();
    }

    @PostMapping
    public Formulario addFormulario(@RequestBody Formulario formulario){
        return formularioService.addFormulario(formulario);
    }
}
