package dgtic.core.servicio;

import dgtic.core.modelo.CarritoCompra;

import java.io.*;
import java.util.Date;

public class Registro {
    private String nombreArchivo;
    private String direccion;
    private BufferedWriter escribir;

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void abrirArchivo() throws IOException {
        File ruta=new File(direccion);
        if(!ruta.exists()){
            ruta.mkdir();
        }
        File registrarArchivo=new File(direccion,nombreArchivo+".txt");
        if(!registrarArchivo.exists()){
            registrarArchivo.createNewFile();
        }
        escribir=new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(registrarArchivo,true)
        ));
    }

    public void verificar(CarritoCompra cart) throws IOException {
        escribir.write(new Date() +"\t"+cart.getArticulos()+"\r\n");
        escribir.flush();
    }

    public void cerrarArchivo() throws IOException {
        escribir.close();
    }
}
