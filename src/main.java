import services.MenuService;

public class main {

    public static void main(String[] args)  {

        MenuService menuService = new MenuService();

        menuService.cargarClientesIniciales();
        menuService.realizarMenuprincipal();


    }
}



