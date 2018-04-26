package samples.callback;

public class SourceCallback {

    private Callback callback;

    public SourceCallback(Callback callback){
        this.callback = callback;
    }

    public void seyHello(){
        callback.sendMessage("Hello world");
    }

}
