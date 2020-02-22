package CartTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.go.bean.Cart;
import com.cg.go.dao.CartDao;
import com.cg.go.dao.CartDaoMapImpl;

class AddCartTest
{
   CartDao dao=null;
   @BeforeEach
   public void setup()
   {
	   dao=new CartDaoMapImpl();
	   
   }
	
	@Test
	void testaddProductToCart() throws Exception
	{
		Cart cart=new Cart();
		cart.setProductId(1089);
		dao.addProductToCart(cart);
		List<Cart> l=dao.findAllProductsInCart();
		assertEquals(1,l.size());
	}
   
}
