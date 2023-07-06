package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.Stock;

import java.util.List;

public interface StockService {
    List<Stock> list_Stock();
    String  sendEmail(String toEmail, String subject,String body);
}
