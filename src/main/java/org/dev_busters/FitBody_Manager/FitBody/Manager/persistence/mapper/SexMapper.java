package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Sex;
import org.mapstruct.Named;
import org.springframework.stereotype.Component; // Opcional pero recomendado si no se usa MapStruct

@Component
public class SexMapper {

    @Named("stringToSex")
    public Sex stringToSex(String sexo) {
        if (sexo == null) {
            return null;
        }
        return Sex.valueOf(sexo.toUpperCase());
    }

    @Named("sexToString")
    public String sexToString(Sex sexo) {
        if (sexo == null) {
            return null;
        }
        return sexo.name();
    }
}