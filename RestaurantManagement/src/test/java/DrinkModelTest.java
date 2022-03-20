
import models.Drink;
import models.ItemsType;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DrinkModelTest {

    @Test
    void testing(){
        Assertions.assertTrue(true);
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SoftDrinkTest{

        @Test
        @Order(1)
        void contructorNoParametor(){
            Drink softDrink = new Drink(ItemsType.drinkType.SOFTDRINK);
            MatcherAssert.assertThat(softDrink, hasProperty("id"));
            MatcherAssert.assertThat(softDrink, hasProperty("name", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("descripton", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("image", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("price", is(0.0)));
            MatcherAssert.assertThat(softDrink, hasProperty("type", is(ItemsType.drinkType.SOFTDRINK)));
        }

        @ParameterizedTest
        @CsvSource({"drink_1, description_1, https:tma1.com.vn, 123.321",
                    "drink_2, description_2, https:tma2.com.vn, 345.23",
                    "drink_3, description_3, https:tma3.com.vn, 456.77",})
        @Order(2)
        void contructorWithParametor(String name, String des, String img, double price){
            Drink softDrink = new Drink(name, des, img, price, ItemsType.drinkType.SOFTDRINK);
            MatcherAssert.assertThat(softDrink, hasProperty("id"));
            MatcherAssert.assertThat(softDrink, hasProperty("name", is(name)));
            MatcherAssert.assertThat(softDrink, hasProperty("descripton", is(des)));
            MatcherAssert.assertThat(softDrink, hasProperty("image", is(img)));
            MatcherAssert.assertThat(softDrink, hasProperty("price", is(price)));
            MatcherAssert.assertThat(softDrink, hasProperty("type", is(ItemsType.drinkType.SOFTDRINK)));
        }

    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class AlcoholDrinkTest{

        @Test
        @Order(1)
        void contructorNoParametor(){
            Drink softDrink = new Drink(ItemsType.drinkType.ALCOHOL);
            MatcherAssert.assertThat(softDrink, hasProperty("id"));
            MatcherAssert.assertThat(softDrink, hasProperty("name", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("descripton", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("image", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("price", is(0.0)));
            MatcherAssert.assertThat(softDrink, hasProperty("type", is(ItemsType.drinkType.ALCOHOL)));
        }

        @ParameterizedTest
        @CsvSource({"Alcohol_1, description_1, https:tma1.com.vn, 123214.53",
                    "Alcohol_2, description_2, https:tma2.com.vn, 345124.32",
                    "Alcohol_3, description_3, https:tma3.com.vn, 456124.1"})
        @Order(2)
        void contructorWithParametor(String name, String des, String img, double price){
            Drink alcohol = new Drink(name, des, img, price, ItemsType.drinkType.ALCOHOL);
            MatcherAssert.assertThat(alcohol, hasProperty("id"));
            MatcherAssert.assertThat(alcohol, hasProperty("name", is(name)));
            MatcherAssert.assertThat(alcohol, hasProperty("descripton", is(des)));
            MatcherAssert.assertThat(alcohol, hasProperty("image", is(img)));
            MatcherAssert.assertThat(alcohol, hasProperty("price", is(price)));
            MatcherAssert.assertThat(alcohol, hasProperty("type", is(ItemsType.drinkType.ALCOHOL)));
        }

    }
}
