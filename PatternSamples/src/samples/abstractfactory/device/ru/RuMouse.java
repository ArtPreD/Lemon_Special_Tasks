package samples.abstractfactory.device.ru;

import samples.abstractfactory.device.Mouse;

public class RuMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("щелчек мышью");
    }

    @Override
    public void dbClick() {
        System.out.println("Двойной щелчек мышью");
    }

    @Override
    public void scroll(int scroll) {
        if (scroll < 0){
            System.out.println("Скролл вниз");
        }else if(scroll > 0){
            System.out.println("Скролл вверх");
        }else {
            System.out.println("не скролим");
        }
    }
}
