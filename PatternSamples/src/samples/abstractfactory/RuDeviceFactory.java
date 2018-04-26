package samples.abstractfactory;

import samples.abstractfactory.device.Keyboard;
import samples.abstractfactory.device.Mouse;
import samples.abstractfactory.device.Touchpad;
import samples.abstractfactory.device.ru.RuKeyboard;
import samples.abstractfactory.device.ru.RuMouse;
import samples.abstractfactory.device.ru.RuTouchpad;

public class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}
