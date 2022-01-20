package ir.maktab.dto;

import ir.maktab.model.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {
    private Long identificationNumber;
    private ExpertDto expertDto;
    private OrderDto orderDto;
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    private Date startTime;
    private OfferStatus offerStatus;
}
