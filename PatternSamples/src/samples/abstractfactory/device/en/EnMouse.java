package samples.abstractfactory.device.en;

import samples.abstractfactory.device.Mouse;

public class EnMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dbClick() {
        System.out.println("Double mouse click");
    }

    @Override
    public void scroll(int scroll) {
        if (scroll < 0){
            System.out.println("Scroll down");
        }else if(scroll > 0){
            System.out.println("Scroll up");
        }else {
            System.out.println("No scrolling");
        }
    }
}
