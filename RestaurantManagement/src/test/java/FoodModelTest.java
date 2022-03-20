
import models.ItemsType;
import models.Food;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FoodModelTest {

    @Test
    @Order(1)
    public void contructorNoParametor(){
        Food food = new Food();
//        MatcherAssert.assertThat(food, hasProperty("id", is(1)));
        MatcherAssert.assertThat(food, hasProperty("name", is(nullValue())));
        MatcherAssert.assertThat(food, hasProperty("descripton", is(nullValue())));
        MatcherAssert.assertThat(food, hasProperty("image", is(nullValue())));
        MatcherAssert.assertThat(food, hasProperty("price", is(0.0)));
        MatcherAssert.assertThat(food, hasProperty("type", is(nullValue())));
    }

    @Test
    @Order(2)
    public void contructorWithParametor(){
        Food food = new Food("abc", "jsadhyiuaw62183", "http:tma.com", 123215.0, ItemsType.foodType.BREAKFAST);

//        MatcherAssert.assertThat(food, hasProperty("id", is(2)));
        MatcherAssert.assertThat(food, hasProperty("name", is("abc")));
        MatcherAssert.assertThat(food, hasProperty("descripton", is("jsadhyiuaw62183")));
        MatcherAssert.assertThat(food, hasProperty("image", is("http:tma.com")));
        MatcherAssert.assertThat(food, hasProperty("price", is(123215.0)));
        MatcherAssert.assertThat(food, hasProperty("type", is(ItemsType.foodType.BREAKFAST)));
    }

    @ParameterizedTest
    @Order(3)
    @EnumSource(ItemsType.foodType.class)
    public void contructorWithEnum(ItemsType.foodType foodType){
        Food food = new Food("abc", "jsadhyiuaw62183", "http:tma.com", 123215.0, foodType);
        Assertions.assertEquals(foodType, food.getType());
    }

}
