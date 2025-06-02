package br.edu.unifacef.bdrestful.repository;

import br.edu.unifacef.bdrestful.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}
