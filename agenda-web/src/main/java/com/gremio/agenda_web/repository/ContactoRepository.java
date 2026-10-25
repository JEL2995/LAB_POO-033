package com.gremio.agenda_web.repository;

import com.gremio.agenda_web.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository
        extends JpaRepository<Contacto, Long> {
}