import com.tma.controller.GSMController;
import com.tma.utils.*;
import org.junit.*;
import org.testng.annotations.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GSMTest {
    @BeforeClass
    public static void start() {
        System.out.println("Start");
    }

    private GSM gsm;

    @BeforeEach
    public void startTest() {
        gsm = new GSM();
    }

    @Test
    @Order(1)
    @DisplayName("Create gsm object with only model and manufactor propeties")
    public void testCreateObj1() {
        String model = "model";
        String manu  = "manufactor";
        gsm = new GSM(model, manu);
        Assert.assertEquals(model, gsm.getModel());
        Assert.assertEquals(manu, gsm.getManufacturer());
        Assert.assertTrue(gsm.getCallHistory().size() == 0);
        Assert.assertTrue(gsm.getPrice() == 0);
        Assert.assertNull(gsm.getDisplay());
        Assert.assertNull(gsm.getBattery());
        Assert.assertNull(gsm.getOwner());
    }


    @Test
    @Order(2)
    @DisplayName("Create gsm object with all propeties")
    public void testCreateObj2() {
        Battery bat = new Battery("model-1", 100, 200, EnumShare.batteryType.LiIon);
        Display dis = new Display(40, 400);
        float price =  300000;

        gsm = new GSM("iphone y", "apple", price, "job", bat, dis);
        Assert.assertEquals("iphone y", gsm.getModel());
        Assert.assertEquals("apple", gsm.getManufacturer());
        Assert.assertEquals("job", gsm.getOwner());

        Assert.assertTrue(price == gsm.getPrice());

        Assert.assertSame(dis, gsm.getDisplay());
        Assert.assertSame(bat, gsm.getBattery());

        Assert.assertTrue(gsm.getCallHistory().size() == 0);
    }

    @DisplayName("Set model")
    @ParameterizedTest
    @ValueSource(strings = {"model_1","model_2","model_3"})
    public void testSetModel(String obj) {
        gsm.setModel(obj);
        Assert.assertEquals(obj, gsm.getModel());
    }

    @DisplayName("Set manufactur")
    @ParameterizedTest
    @ValueSource(strings = {"manu_1","manu_2","manu_3"})
    public void testSetManu(String obj) {
        gsm.setManufacturer(obj);
        Assert.assertEquals(obj, gsm.getManufacturer());
    }

    @DisplayName("Set owner")
    @ParameterizedTest
    @ValueSource(strings = {"owner_1","owner_2","owner_3"})
    public void testSetOwner(String obj) {
        gsm.setOwner(obj);
        Assert.assertEquals(obj, gsm.getOwner());
    }


    @DisplayName("Set price")
    @ParameterizedTest
    @ValueSource(floats = {29000, 12324, 52155})
    public void testSetManu(float obj) {
        gsm.setPrice(obj);
        Assert.assertTrue(obj == gsm.getPrice());
    }

    @ParameterizedTest
    @CsvSource({"2,300", "4,500", "7,100"})
    public void testSetDisplay(int size, int color) {
        Display dis = new Display(size, color);
        gsm.setDisplay(dis);
        Assert.assertSame(dis, gsm.getDisplay());
    }

    @ParameterizedTest
    @CsvSource({"model1, 100, 200"})
    public void testSetBattery(String model, float a, float b) {
        Battery bat = new Battery(model, a, b, EnumShare.batteryType.LiIon);
        gsm.setBattery(bat);
        Assert.assertSame(bat, gsm.getBattery());
    }

    @ParameterizedTest
    @CsvSource({"2.3, 12345678", "4.4, 128649821", "7, 219740921"})
    public void testCreateCall(float dura, String number){
        Call call = new Call(dura, number);
        gsm.createCall(call);
        Assert.assertTrue(gsm.getCallHistory().size() == 1);
        Assert.assertSame(call, gsm.getCallHistory().get(0));
    }

    @Test
    public void clearCall(){
        gsm = new GSM();
        Call call1 = new Call(200, "213213321");
        Call call2 = new Call(20, "213213321");
        Call call3 = new Call(100, "213213321");
        gsm.createCall(call1);
        gsm.createCall(call2);
        gsm.createCall(call3);
        gsm.clearCall();
        Assert.assertTrue(gsm.getCallHistory().size() == 0);
    }

    @Test
    public void removeLongestCall(){
        gsm = new GSM();
        Call call1 = new Call(200, "213213321");
        Call call2 = new Call(20, "213213321");
        Call call3 = new Call(100, "213213321");
        gsm.createCall(call1);
        gsm.createCall(call2);
        gsm.createCall(call3);
        gsm.removeLongestCall();
        Assert.assertTrue(gsm.getCallHistory().size() == 2);
        Assert.assertSame(call2, gsm.getCallHistory().get(0));
        Assert.assertFalse(gsm.getCallHistory().contains(call1));
    }

    @After
    public void endTest() {
        System.out.println("End Test case");
    }

    @AfterClass
    public static void end() {
        System.out.println("End");
    }
}
