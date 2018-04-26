package samples.abstractfactory.device.ru;

import samples.abstractfactory.device.Touchpad;

public class RuTouchpad implements Touchpad {

    @Override
    public void track(int x, int y) {
        int s = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("Передвинули на " + s + " пикселей");
    }
}
