package ma.cigma.mypef.controllers;

import ma.cigma.mypef.services.DashboardService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private DashboardService dashboardService;

    public DashboardController(@Qualifier("dash_service") DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/Vente_T")
    public String Vente_T(){
        return dashboardService.Vente_T();
    }
    @GetMapping("/Vente_M")
    public String Vente_M(){
        return dashboardService.Vente_M();
    }

    @GetMapping("/Vente_J")
    public String Vente_J(){
        return dashboardService.Vente_J();
    }

    @GetMapping("/NB_client")
    public int Nombre_Client(){
        return dashboardService.Nombre_Client();
    }

    @GetMapping("/NB_medicament")
    public int Nombre_Medicament(){
        return dashboardService.Nombre_Medicament();
    }

    @GetMapping("/Qte_medicament_expire")
    public int Qte_Medicament_Expire(){
        return dashboardService.Medicament_Qte_Expire();
    }
    @GetMapping("/Date_medicament_expire")
    public int Date_Medicament_Expire(){
        return dashboardService.Medicament_Date_Expire();
    }

    @GetMapping("/Nombre_Entrees_J")
    public int Nombre_Entrees_J(){
        return dashboardService.Nombe_Entree_J();
    }
}
