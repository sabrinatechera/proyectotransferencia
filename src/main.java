import services.MenuService;

public class main {

    public static void main(String[] args)  {

        MenuService objMenuService = new MenuService();

        objMenuService.cargarClientesIniciales();
        objMenuService.realizarMenuprincipal();


    }
}



