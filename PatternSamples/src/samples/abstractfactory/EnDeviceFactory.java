package samples.abstractfactory;

import samples.abstractfactory.device.Keyboard;
import samples.abstractfactory.device.Mouse;
import samples.abstractfactory.device.Touchpad;
import samples.abstractfactory.device.en.EnKeyboard;
import samples.abstractfactory.device.en.EnMouse;
import samples.abstractfactory.device.en.EnTouchpad;

public class EnDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}
