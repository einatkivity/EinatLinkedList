import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MyLinkedList Tester.
 *
 * @author <Authors name>
 * @since <pre>Aug 18, 2019</pre>
 * @version 1.0
 */
public class LidorLinkedListTest {
    IMyLinkedList myList;
    @Before
    public void before() throws Exception {

        myList = new EinatMyLinkedList<Point>(new Point(0,0));
        myList.addAfter(0,new Point(1,1));
        myList.addAfter(1,new Point(2,2));
        myList.addAfter(2,new Point(3,3));
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: addAfter(int i, Object data)
     *
     */
    @Test
    public void testAddAfter() throws Exception {

        // check valid points
        Point secondPoint = new Point(1,1);
        myList.addAfter(0, secondPoint);
        Object fromList = myList.getData(1);

        Assert.assertEquals(secondPoint,fromList);



        //TODO: Test goes here...
    }

//todo

    /**
     *
     * Method: getIndex(Object data)
     *
     */
    @Test
    public void testGetIndex() throws Exception {

        //valid input
        Point lastPoint = new Point(4,5);
        myList.addAfter(3,lastPoint);
        int res = myList.getIndex(lastPoint);

        Assert.assertEquals(4,res);

        //invalid input
        int i = 0 ;
        myList.addAfter(3,i);
        int res2 = myList.getIndex(i);
        Assert.assertNotSame(4,res2);



//TODO: Test goes here...
    }

    /**
     *
     * Method: remove(int index)
     *
     */
    @Test
    public void testRemove() throws Exception {
        //valid input
        Point lastPoint = new Point(4,5);
        myList.addAfter(3,lastPoint);
        myList.removeAt(4);
        int res = myList.getIndex(lastPoint);

        Assert.assertNotSame(4,res);



        //TODO: Test goes here...
    }

    /**
     *
     * Method: printList()
     *
     */
    @Test
    public void testPrintList() throws Exception {
//TODO: Test goes here...
    }


}
