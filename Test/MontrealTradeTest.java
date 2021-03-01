import com.monntreal.Exceptions.ProductAlreadyRegisteredException;
import com.monntreal.interfaces.MontrealTradedProducts;
import com.monntreal.interfaces.ProductPricingService;
import com.monntreal.product.Futures;
import com.monntreal.product.Product;
import com.monntreal.product.Stock;
import com.monntreal.trade.MontrealTrade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//@ExtendWith(MockitoExtension.class)
public class MontrealTradeTest {
    @Mock
    MontrealTrade montrealTradedProducts;
    @Mock
    Product stock;
    @Mock
    Product future;
    @Mock
    ProductPricingService productPricingService;

    @BeforeEach
    void setUp() {
        montrealTradedProducts = new MontrealTrade();
        stock = new Stock("001","LON","APPL");
        future = new Futures("002","DEF","GGD",12,2021);
        Mockito.when(productPricingService.price(Mockito.anyString(),Mockito.anyString())).thenReturn(10.0);
        Mockito.
                when(productPricingService.price(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt()))
                .thenReturn(10.0);

    }

    @Test
    void testAddNewProduct() throws ProductAlreadyRegisteredException{
        Product product = new Stock("001","LON","APPL");
        montrealTradedProducts.addNewProduct(product);
        Assertions.assertEquals(montrealTradedProducts.getLengthOfProductList(), 1);
    }

    @Test
    void testTotalValueOfDaysTradedProducts() throws ProductAlreadyRegisteredException{
        Product product = new Stock("001","LON","APPL");
        montrealTradedProducts.addNewProduct(product);
        montrealTradedProducts.trade(product,1);
        Assertions.assertEquals(10,montrealTradedProducts.totalTradeQuantityForDay());

    }

    @Test
    void addNewProductShouldThrowException(){
        Assertions.assertThrows(ProductAlreadyRegisteredException.class,()->{

            montrealTradedProducts.addNewProduct(stock);
            montrealTradedProducts.addNewProduct(stock);
        });

    }



}