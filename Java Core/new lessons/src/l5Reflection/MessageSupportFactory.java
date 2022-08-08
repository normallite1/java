package l5Reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MessageSupportFactory {
    private MessageProvider mesprov =null;
    private RenderMessage renprov = null;

    public MessageSupportFactory(File file){
        super();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            mesprov = (MessageProvider) Class.forName(br.readLine()).newInstance();
            renprov = (RenderMessage) Class.forName(br.readLine()).newInstance();

        } catch (IOException | InstantiationException | IllegalAccessException | NullPointerException | ClassNotFoundException e) {
            System.out.println(e);
        }

    }
    public MessageProvider getMesprov() {
        return mesprov;
    }

    public RenderMessage getRenprov() {
        return renprov;
    }
}
