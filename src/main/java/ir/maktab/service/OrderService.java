package ir.maktab.service;

import ir.maktab.dao.OrderDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderService {
    private OrderDao orderDao;
}
