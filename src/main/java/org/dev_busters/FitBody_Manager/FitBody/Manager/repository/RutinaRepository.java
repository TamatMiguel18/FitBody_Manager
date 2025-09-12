    package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

    import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RutinaDto;
    import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudRutinaEntity;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface RutinaRepository{

        List<RutinaDto> obtenerTodo();
        RutinaDto buscarPorCodigo(Long idRutina);
        RutinaDto guardarRutina(RutinaDto rutinaDto);
        RutinaDto modificarRutina(Long idRutina);
    }
