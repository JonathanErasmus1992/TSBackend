package toystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import toystore.App;
import toystore.domain.Item;
import toystore.repository.ItemRepository;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testAddItemService extends AbstractTestNGSpringContextTests {
    @Autowired
    AddItemService addItemService;
    @Autowired
    ItemRepository itemRepository;

    private boolean bool;
    @BeforeMethod
    public void setUp()
    {
        bool = false;
    }

    @Test
    public void testAddItem()
    {
        bool = addItemService.addItem("Teddybear", "kiddies", 6, 200);
        Assert.assertTrue(bool);
        bool = addItemService.addItem("Teddybear", "kiddies", 6, 200);
        Assert.assertFalse(bool);
    }

    @AfterMethod
    public void tearDown()
    {
        Long id = Long.parseLong("0");
        Iterable<Item> items = itemRepository.findAll();
        for(Item item: items)
        {
            if(item.getID()>id)
                id = item.getID();
        }
        itemRepository.delete(id);
    }
}
