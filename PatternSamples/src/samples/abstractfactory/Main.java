package samples.abstractfactory;

import samples.abstractfactory.device.Keyboard;
import samples.abstractfactory.device.Mouse;
import samples.abstractfactory.device.Touchpad;

public class Main {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = getDeviceFactoryByLang("RU");

        Mouse mouse = deviceFactory.getMouse();
        Keyboard keyboard = deviceFactory.getKeyboard();
        Touchpad touchpad = deviceFactory.getTouchpad();

        mouse.dbClick();
        keyboard.println();
        touchpad.track(25, 37);

    }

    public static DeviceFactory getDeviceFactoryByLang(String lang){
        if (lang.equals("RU")){
            return new RuDeviceFactory();
        }else if (lang.equals("EN")){
            return new EnDeviceFactory();
        }

        throw new RuntimeException("Нет языкового пакета " + lang);
    }
    
}
