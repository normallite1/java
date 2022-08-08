package l5Reflection;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        File file = new File("config");
        MessageSupportFactory msf = new MessageSupportFactory(file);
        MessageProvider mprov = msf.getMesprov();
        RenderMessage renMes = msf.getRenprov();
        renMes.setMassageProvider(mprov);
        renMes.renderMassage();
        }
    }

