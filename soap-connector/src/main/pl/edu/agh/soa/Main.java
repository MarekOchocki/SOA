package pl.edu.agh.soa;

import javax.xml.ws.BindingProvider;
import java.io.FileOutputStream;
import java.util.Base64;

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

        String base64Image = service.downloadAvatar(2);

        String destinationFilepath = "/home/marek/SOA/downloaded_avatar.jpg";
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFilepath)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (Exception ignored) {
        }
    }

    private static void addCredentials(MainSoapService service){
        BindingProvider prov = (BindingProvider) service;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "test");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "test1");
    }
}
