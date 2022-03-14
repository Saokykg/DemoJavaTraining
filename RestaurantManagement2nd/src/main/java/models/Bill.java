package models;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private static int counter = 1;
    private int id;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private List<OrderDetail> orders;
    private int idCustomer;
}
