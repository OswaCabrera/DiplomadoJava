package dgtic.core.inicio;


import dgtic.core.modelo.*;
import dgtic.core.servicio.ConfiguracionServicio;
import dgtic.core.servicio.Registro;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Map;

public class Inicio {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(
          //      new String[]{"bean-configuration.xml", "bean-services.xml"});

        //ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext("dgtic.core");

        ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext(ConfiguracionServicio.class);

        Producto coca = contexto.getBean("chico", Producto.class);
        System.out.println(coca.toString());

        Producto pila = contexto.getBean("sonyPilas", Producto.class);
        System.out.println(pila.toString());

        Producto pila2 = contexto.getBean("sonyPilas", Producto.class);
        System.out.println(pila2.toString());

        System.out.println("Lista de productos");

        ListaProductos listaProductos = contexto.getBean(ListaProductos.class);
        for (Producto producto : listaProductos.getListaProductos()) {
            System.out.println(producto.toString());
        }

        System.out.println("Mapa");
        ListaProductos mapaProductos = contexto.getBean(ListaProductos.class);
        for (Map.Entry<String, Producto> entry : mapaProductos.getMapaProducto().entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }


        // Referrencia Circular
        ClaseA claseA = contexto.getBean(ClaseA.class);
        System.out.println(claseA.toString());
        ClaseB claseB = contexto.getBean(ClaseB.class);
        System.out.println(claseB.toString());

        System.out.println("Carrito Compras");
        CarritoCompra carritoCompra = contexto.getBean("carritoCompra",CarritoCompra.class);
        carritoCompra.agregarArticulos(coca);
        carritoCompra.agregarArticulos(pila);


        Registro registro = contexto.getBean("registrar", Registro.class);
        try{
            registro.abrirArchivo();
            registro.verificar(carritoCompra);
        }catch (IOException e){
            e.printStackTrace();
        }

        contexto.close();
    }
}
