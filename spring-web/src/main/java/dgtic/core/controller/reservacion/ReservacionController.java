package dgtic.core.controller.reservacion;

import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.model.entity.HabitacionEntity;
import dgtic.core.model.entity.HotelEntity;
import dgtic.core.model.entity.ReservacionEntity;
import dgtic.core.service.cliente.ClienteService;
import dgtic.core.service.habitacion.HabitacionService;
import dgtic.core.service.hotel.HotelService;
import dgtic.core.service.reservacion.ReservacionService;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("reservacion")
@SessionAttributes("nombreBuscar")
public class ReservacionController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    HotelService hotelService;

    @Autowired
    HabitacionService habitacionService;

    @Autowired
    ReservacionService reservacionService;



    @GetMapping("alta-reservacion")
    public String altaReservacion(Model model){
        ReservacionEntity reservacionEntity=new ReservacionEntity();
        model.addAttribute("operacion","Alta Reservación");
        model.addAttribute("reservacion",reservacionEntity);
        return "reservacion/alta-reservacion";
    }
    @PostMapping("alta-reservacion")
    public String altaReservacionGuardar(@Valid @ModelAttribute("reservacion") ReservacionEntity reservacion
                                ,BindingResult result,
                                  Model model, RedirectAttributes flash){
        System.out.println(reservacion);
        reservacionService.guardar(reservacion);
        flash.addFlashAttribute("success","Reservación se almaceno con éxito");
        return "redirect:/reservacion/alta-reservacion";
    }
    @GetMapping("buscar-reservacion")
    public String buscarReservacion(Model model){
        ReservacionEntity reservacionEntity=new ReservacionEntity();
        List<ReservacionEntity> lista=new ArrayList<>();
        model.addAttribute("operacion","Buscar Reservación");
        model.addAttribute("reservacion",reservacionEntity);
        model.addAttribute("reservaciones",lista);
        return "reservacion/buscar-reservacion";
    }
    @PostMapping("buscar-reservacion")
    public String buscarReservaconTabla(@Valid @ModelAttribute("reservacion") ReservacionEntity reservacion
                                        ,BindingResult result,
                                        Model model, RedirectAttributes flash){
        //almacenando la sesion
        model.addAttribute("nombreBuscar",reservacion.getCliente().getNombre());
        List<ReservacionEntity> lista=
                reservacionService.buscarReservacionPatron(reservacion.getCliente().getNombre());
        System.out.println(lista.size()+"<---");
        for (ReservacionEntity r:lista) {
            System.out.println(r.toString());
        }
        flash.addFlashAttribute("usuarioNombre",reservacion.getCliente().getNombre());
        model.addAttribute("reservaciones",lista);
        return "reservacion/buscar-reservacion";
    }
    @GetMapping("pdf")
    public String generarPdf(Model model, SessionStatus status, HttpSession sesion){
        //obteniendo la variable de sesión
        String nombre=(String)sesion.getAttribute("nombreBuscar");
        List<ReservacionEntity> lista=
                reservacionService.buscarReservacionPatron(nombre);
        model.addAttribute("datos",lista);
        //matando la sesión
        status.setComplete();
        gmail(lista);
        return "reservacion/buscar-reservacion";
    }

    @GetMapping(value = "buscar-cliente/{dato}",produces = "application/json")
    public @ResponseBody List<ClienteEntity> buscarCliente(@PathVariable String dato){
        return clienteService.buscarClientePatron(dato);
    }
    @GetMapping(value = "buscar-hotel/{dato}",produces = "application/json")
    public @ResponseBody List<HotelEntity> buscarHotel(@PathVariable String dato){
        return hotelService.buscarHotelPatron(dato);
    }
    @GetMapping(value = "buscar-habitacion/{dato}",produces = "application/json")
    public @ResponseBody List<HabitacionEntity> buscarHabitacion(@PathVariable String dato){
        return habitacionService.buscarHabitacionHotel(dato);
    }

    //proba mensaje
    private void gmail( List<ReservacionEntity> lista){
        String gmail="oswaldo121oswaldo@gmail.com";
        String pswd="zrzm uats deui mdul";
        Properties p=System.getProperties();
        p.setProperty("mail.smtps.host","smpt.gmail.com");
        p.setProperty("mail.smtps.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtps.socketFactory.fallback","false");
        p.setProperty("mail.smtp.port","465");
        p.setProperty("mail.smtp.socketFactory.port","465");
        p.setProperty("mail.smtps.auth","true");
        p.setProperty("mail.smtp.ssl.trust","smtp.gmail.com");
        p.setProperty("mail.smtps.ssl.trust","smtp.gmail.com");
        p.setProperty("mail.smtp.ssl.quitwait","false");
        //construcción del html
        String cadena="<h2>Nombre|Fecha reservación|Fecha inicio|Hotel|habitación|Precio</h2></br>";
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        for (ReservacionEntity s:lista ) {
            cadena+="<h2>"+s.getCliente().getNombre()+"|"+
                    f.format(s.getFechaReservacion())+"|"+
                    f.format(s.getFechaInicio())+"|"+
                    s.getHabitacion().getHotel().getNombre()+"|"+
                    s.getHabitacion().getNombre()+"|"+
                    s.getHabitacion().getPrecio()+"</h2></br>";
        }
        try{
            Session session=Session.getInstance(p,null);
            MimeMessage message=new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("oswaldo121oswaldo@gmail.com",false));
            message.setSubject("Se mando");
            message.setContent(cadena,"text/html");
            message.setSentDate(new Date());

            Transport transport=(Transport)session.getTransport("smtps");
            transport.connect("smtp.gmail.com",gmail,pswd);
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(format,false));
    }


}
