import static org.junit.Assert.*;

import java.util.ArrayList;

import net.xicp.zyl_me.dao.CategoryDAO;
import net.xicp.zyl_me.dao.impl.CategoryDAOImpl;
import net.xicp.zyl_me.entity.Category;

import org.junit.Test;


public class CategoryDAOTest {
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		ArrayList<Category> arrayList = categoryDAO.getAll();
		for(Category category :arrayList)
		{
			System.out.println(category);
		}
	}

	@Test
	public void testGetByIdInt() {
		fail("Not yet implemented");
	}
}
