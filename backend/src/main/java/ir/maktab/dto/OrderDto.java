package ir.maktab.dto;

import ir.maktab.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long identificationNumber;
    private SubServiceDto subServiceDto;
    private Long proposedPrice;
    private String jobDescription;
    private Date orderRegistrationDate;
    private Date dateOfWorkPerformed;
    private AddressDto addressDto;
    private CustomerDto customerDto;
    private OrderStatus orderStatus;
    private ExpertDto expertDto;
}
