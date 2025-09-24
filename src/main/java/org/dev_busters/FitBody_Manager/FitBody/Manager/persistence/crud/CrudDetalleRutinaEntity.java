package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud;

import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.DetalleRutinaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDetalleRutinaEntity
        extends CrudRepository<DetalleRutinaEntity, Long> {
    DetalleRutinaEntity findByIdDetalleRutina(Long idDetalleRutina);
}