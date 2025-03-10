package br.com.fiap.ms_produto.controller.handlers.dto;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO extends CustomErrorDTO {

    private List<FieldMessageDTO> errors = new ArrayList<>();

    public ValidationErrorDTO(Instant timeStamp, Integer status, String error, String path) {

        super(timeStamp, status, error, path);
    }

    public void addError(String fieldName, String message) {
        //remove erro de campos duplicados
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FieldMessageDTO(fieldName, message));
    }


}
