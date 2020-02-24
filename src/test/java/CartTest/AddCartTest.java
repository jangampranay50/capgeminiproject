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
   CartDao cartdao=null;
   @BeforeEach
   public void setup()
   {
	   cartdao=new CartDaoMapImpl();
	   
   }
	
   //testing (adding product to cart)
	@Test
	void testaddProductToCart() throws Exception
	{
		Cart cart=new Cart();
		cart.setProductId(1001);
		cartdao.addProductToCart(cart);
		List<Cart> l=cartdao.findAllProductsInCart();
		assertEquals(1,l.size());
	}
	
	//testing (deleting product from cart)
	@Test
	void testdeleteProductFromCart() throws Exception
	{
		Cart cart=new Cart();
		cart.setProductId(1001);
		cartdao.addProductToCart(cart);
		List<Cart> l=cartdao.findAllProductsInCart();
		cart=cartdao.deleteProductByIdInCart(1001);
		assertEquals(1,l.size());
	}
	
}
