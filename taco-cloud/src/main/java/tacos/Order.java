package tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class Order {

    private Long id;

    @NotBlank(message = "is requrired")
    private String deliveryName;
    @NotBlank(message = "is requrired")
    private String deliveryStreet;
    @NotBlank(message = "is requrired")
    private String deliveryCity;
    @NotBlank(message = "is requrired")
    private String deliveryState;
    @NotBlank(message = "is requrired")
    private String deliveryZip;
    @CreditCardNumber(message = "valid credit card")
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private LocalDateTime placedAt;
}
