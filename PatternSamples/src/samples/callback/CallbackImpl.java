package samples.callback;

public class CallbackImpl {

    private static Callback callback = message -> {
        //Reaction on something
        System.out.println("I got a message: " + message);
    };

    public static void main(String[] args) {
        SourceCallback sourceCallback = new SourceCallback(callback);

        sourceCallback.seyHello();
    }
}
