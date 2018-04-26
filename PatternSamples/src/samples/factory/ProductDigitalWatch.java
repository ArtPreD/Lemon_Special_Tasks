package samples.factory;

import java.util.Date;

public class ProductDigitalWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
