package dgtic.core.validation;

import dgtic.core.model.entity.HotelEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class HotelValidacion implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return HotelEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HotelEntity hotel = (HotelEntity) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotBlank.hotelEntity.nombre");
    }
}
