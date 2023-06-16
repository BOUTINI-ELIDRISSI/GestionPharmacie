package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.Stock;
import ma.cigma.mypef.services.StockService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {
    private StockService service;

    public StockController(@Qualifier("stock_service") StockService service) {
        this.service = service;
    }
    @GetMapping("list_stock")
    public List<Stock> Stock_List(){
        return service.list_Stock();
    }
}
