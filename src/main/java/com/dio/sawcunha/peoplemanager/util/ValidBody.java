package com.dio.sawcunha.peoplemanager.util;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.NotValidException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.model.AttributeNotValid;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidBody{

    public void validBody(BindingResult result, eMessageError messageError) throws NotValidException {
        if(result.hasErrors()){
            List<AttributeNotValid> erros = result.getAllErrors().stream().map( error -> new AttributeNotValid(getAttribute(error),error.getDefaultMessage())).collect(Collectors.toList());
            throw new NotValidException(messageError, erros);
        }
    }

    private String getAttribute(ObjectError error){
        String attribute = null;
        String[] temp;
        try{
            if(error.getCodes() != null) {
                temp = error.getCodes()[0].split("\\.");
                int index = 1;
                attribute = temp[index++];
                for(; index<temp.length;index++)
                    attribute = String.format("%s.%s",attribute,temp[index]);
            } else {
                attribute = "Not identified";
            }
        }catch (Exception e){
            attribute = "Not identified";
        }finally {
            temp = null;
            return attribute;
        }
    }

}
