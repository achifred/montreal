import com.monntreal.Exceptions.ProductAlreadyRegisteredException;
import com.monntreal.interfaces.MontrealTradedProducts;
import com.monntreal.product.Futures;
import com.monntreal.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class);
class MontrealTradeTest {
    @Mock
    MontrealTradedProducts montrealTradedProducts;
    @Mock
    Product product;
    @Mock
    Product stock;
    @Mock
    Product futures;

    @BeforeEach
    void setUp() throws Exception{
        //futures = new Futures();
        //Mockito.when(montrealTradedProducts.addNewProduct(product)).thenThrow(ProductAlreadyRegisteredException.class);
        Mockito.when(montrealTradedProducts.totalTradeQuantityForDay()).thenReturn(74);
        Mockito.when(montrealTradedProducts.totalValueOfDaysTradedProducts()).thenReturn(80.5);

    }

    @Test
    void testTotalTradeQuantityForDay(){
        Mockito.verify(montrealTradedProducts).totalTradeQuantityForDay();
    }
    @Test
    void testTotalValueOfDaysTradedProducts(){
        Mockito.verify(montrealTradedProducts).totalValueOfDaysTradedProducts();
    }

    @Test
    void ddNewProductShouldThrowException(){
        Assertions.assertThrows(ProductAlreadyRegisteredException.class,()->{
            montrealTradedProducts.addNewProduct(product);
        });

    }



}