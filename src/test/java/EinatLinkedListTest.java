import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MyLinkedList Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2019</pre> 
* @version 1.0 
*/ 
public class EinatLinkedListTest {

    IMyLinkedList<Point> list = new EinatMyLinkedList<Point>(new Point(1,1));


@Before
public void before() throws Exception {

    list.addAfter(0, new Point(3,3));
    list.addAfter(1, new Point(5,5));
    list.addAfter(2, new Point(7,7));

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getLink(int index) 
* 
*/ 
@Test
public void testGetLink() throws Exception {
    Assert.assertEquals(new Point(1,1), list.getData(0));
    Assert.assertEquals(new Point(3,3), list.getData(1));
//TODO: Test goes here... 
} 

/** 
* 
* Method: addAfter(int index, Object data) 
* 
*/ 
@Test
public void testAddAfter() throws Exception {
    Assert.assertEquals(new Point(5,5), list.getData(2));
//TODO: Test goes here... 
} 

/** 
* 
* Method: getIndex(Object data) 
* 
*/ 
@Test
public void testGetIndex() throws Exception {
    Assert.assertEquals(new Point(5,5), list.getData(2));
//TODO: Test goes here... 
} 

/** 
* 
* Method: removeAt(int index) 
* 
*/ 
@Test
public void testRemoveAt() throws Exception {
    list.removeAt(0);
    Assert.assertEquals(new Point(3,3), list.getData(0));//todo
//TODO: Test goes here... 
} 

/** 
* 
* Method: print(List list) 
* 
*/ 
@Test
public void testPrint() throws Exception {
    Assert.assertEquals( "Point{" + "x=" + 1 + ", y=" + 1 + '}', list.getData(0).toString());
    Assert.assertEquals( "Point{" + "x=" + 3 + ", y=" + 3 + '}', list.getData(1).toString());
//TODO: Test goes here...
} 


} 
