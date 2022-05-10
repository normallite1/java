package l5Reflection;

public class MessageRenderClass implements RenderMessage {
   private MessageProvider mesprov = null;
    @Override
    public void renderMassage() {
        if (mesprov==null){
            throw new IllegalArgumentException("Set message provider");
        }
        System.out.println(mesprov.getMessage());
    }

    @Override
    public void setMassageProvider(MessageProvider mesprov) {
        this.mesprov = mesprov;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return mesprov;
    }
}
