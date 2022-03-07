
import models.Alcohol;
import models.Enum;

import models.SoftDrink;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.nullValue;

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
            SoftDrink softDrink = new SoftDrink();
            MatcherAssert.assertThat(softDrink, hasProperty("id"));
            MatcherAssert.assertThat(softDrink, hasProperty("name", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("descripton", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("image", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("price", is(0.0)));
            MatcherAssert.assertThat(softDrink, hasProperty("type", is(Enum.drinkType.SOFTDRINK)));
        }

        @ParameterizedTest
        @CsvSource({"drink_1, description_1, https:tma1.com.vn, 123.321",
                    "drink_2, description_2, https:tma2.com.vn, 345.23",
                    "drink_3, description_3, https:tma3.com.vn, 456.77",})
        @Order(2)
        void contructorWithParametor(String name, String des, String img, double price){
            SoftDrink softDrink = new SoftDrink(name, des, img, price);
            MatcherAssert.assertThat(softDrink, hasProperty("id"));
            MatcherAssert.assertThat(softDrink, hasProperty("name", is(name)));
            MatcherAssert.assertThat(softDrink, hasProperty("descripton", is(des)));
            MatcherAssert.assertThat(softDrink, hasProperty("image", is(img)));
            MatcherAssert.assertThat(softDrink, hasProperty("price", is(price)));
            MatcherAssert.assertThat(softDrink, hasProperty("type", is(Enum.drinkType.SOFTDRINK)));
        }

    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class AlcoholDrinkTest{

        @Test
        @Order(1)
        void contructorNoParametor(){
            Alcohol softDrink = new Alcohol();
            MatcherAssert.assertThat(softDrink, hasProperty("id"));
            MatcherAssert.assertThat(softDrink, hasProperty("name", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("descripton", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("image", is(nullValue())));
            MatcherAssert.assertThat(softDrink, hasProperty("price", is(0.0)));
            MatcherAssert.assertThat(softDrink, hasProperty("type", is(Enum.drinkType.ALCOHOL)));
            MatcherAssert.assertThat(softDrink, hasProperty("concentration", is(0.0)));
        }

        @ParameterizedTest
        @CsvSource({"Alcohol_1, description_1, https:tma1.com.vn, 123214.53, 50",
                    "Alcohol_2, description_2, https:tma2.com.vn, 345124.32, 70",
                    "Alcohol_3, description_3, https:tma3.com.vn, 456124.1 , 80"})
        @Order(2)
        void contructorWithParametor(String name, String des, String img, double price, double concentration){
            Alcohol alcohol = new Alcohol(name, des, img, price, concentration);
            MatcherAssert.assertThat(alcohol, hasProperty("id"));
            MatcherAssert.assertThat(alcohol, hasProperty("name", is(name)));
            MatcherAssert.assertThat(alcohol, hasProperty("descripton", is(des)));
            MatcherAssert.assertThat(alcohol, hasProperty("image", is(img)));
            MatcherAssert.assertThat(alcohol, hasProperty("price", is(price)));
            MatcherAssert.assertThat(alcohol, hasProperty("concentration", is(concentration)));
            MatcherAssert.assertThat(alcohol, hasProperty("type", is(Enum.drinkType.ALCOHOL)));
        }

    }
}
