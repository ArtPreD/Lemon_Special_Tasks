package samples.abstractfactory;

import samples.abstractfactory.device.Keyboard;
import samples.abstractfactory.device.Mouse;
import samples.abstractfactory.device.Touchpad;

public interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
