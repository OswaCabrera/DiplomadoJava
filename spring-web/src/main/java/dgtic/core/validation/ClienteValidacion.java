package dgtic.core.validation;


import dgtic.core.model.entity.ClienteEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class ClienteValidacion implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClienteEntity cliente = (ClienteEntity) target;
        //if (cliente.getApellidoPaterno()==null || cliente.getApellidoPaterno().regionMatches(0," ",0,1)){
          //  errors.rejectValue("apellidoPaterno","field.required","NotBlank.cliente.apellidoPaterno");
        //}
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"apellidoPaterno","NotBlank.clienteEntity.apellidoPaterno");
    }
}
