package pl.edu.agh.soa;

import javax.xml.ws.BindingProvider;

public class Main {

    public static void main(String[] args)
    {
        MainSoapServiceService serviceService =  new MainSoapServiceService();
        MainSoapService service = serviceService.getMainSoapServicePort();

        addCredentials(service);

        service.addStudent("Magdalena", 3);
        Student a = service.getStudent(3);
        System.out.println(a.name);
        System.out.println(a.id);
    }

    public static void addCredentials(MainSoapService service){
        BindingProvider prov = (BindingProvider) service;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user2");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "password");
    }
}
