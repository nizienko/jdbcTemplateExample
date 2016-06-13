package example;

/**
 * Created by def on 13.06.2016.
 */
public class SomeService {

    public static void main(String args[]) {
        SomeDao someDao = new SomeDao();
        String result = someDao.selectSomething("Some name");
    }
}
