import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZaxTests {


    IMyLinkedList pointsListA1;
    IMyLinkedList pointsListA2;

    IMyLinkedList constraintList;

    /* Map with 2 Agents */
    /*

        0  | 1  | 2  | 3
    0 [ 0  , S1 , 0  , 0  ]
    1 [ S2 , 0  , 0  , 0  ]
    2 [ 0  , 0  , 0  , G2 ]
    3 [ 0  , 0  , G1 , 0  ]

    Time:   0        1        2        3        4
    A1  : (1,0) -> (2,0) -> (2,1) -> (2,2) -> (2,3) ->
    A2  : (0,1) -> (1,1) -> (2,1) -> (2,2) -> (3,2) ->


    * */



    @Before
    public void before() throws Exception {




        pointsListA1 = new EinatMyLinkedList(new Point(1,0));
        pointsListA1.addAfter(0,new Point(2,0));
        pointsListA1.addAfter(1,new Point(2,1));
        pointsListA1.addAfter(2,new Point(2,2));
        pointsListA1.addAfter(3,new Point(2,3));

        pointsListA2 = new EinatMyLinkedList(new Point(0,1));
        pointsListA2.addAfter(0,new Point(1,1));
        pointsListA2.addAfter(1,new Point(2,1));
        pointsListA2.addAfter(2,new Point(2,2));
        pointsListA2.addAfter(3,new Point(3,2));



        constraintList = new EinatMyLinkedList<Constraint>(new Constraint(1,new Point(2,1),2));

    }

    @After
    public void after() throws Exception {



    }



/***************              Tests           *****************/




    /**
     *
     * Method: addAfter(Object data, int i)
     *
     */
    @Test
    public void testAddAfter() throws Exception {

        /***             Points List             ***/
        /*  invalid values  */

        // Checks out of bound
        pointsListA1.addAfter(-5,new Point(100,100));
        pointsListA1.addAfter(10,new Point(100,100));

        //  null values
        pointsListA1.addAfter(2,null);
        Assert.assertNotNull(pointsListA1.getData(3));

        /*  valid values  */
        pointsListA1.addAfter(2,new Point(2,1));
        Assert.assertEquals(new Point(2,1), pointsListA1.getData(3));





        /***             Constraints List             ***/
        /*  invalid values  */
        constraintList.addAfter(0,new Constraint(1,new Point(2,2),3));
    }


    /**
     *
     * Method: getIndex(Object data)
     *
     */
    @Test
    public void testGetIndex() throws Exception {

        /* invalid values */
        Assert.assertEquals( pointsListA1.getIndex(new Point(100,100)), -1);

        /* valid values */
        Point point = new Point(1,0);
        int i = pointsListA1.getIndex(point);

        Assert.assertEquals(i,0);
    }

    /**
     *
     * Method: removeAt(int i)
     *
     */
    @Test
    public void testRemoveAt() throws Exception {

        /* valid values */
        pointsListA1.removeAt(2);
        Assert.assertEquals(new Point(1,0),pointsListA1.getData(0));
    }

    /**
     *
     * Method: printList()
     *
     */
    @Test
    public void testPrintList() throws Exception {

        /* valid values */
        String expectedValuePointsA1 = "Point{x_value=1, y_value=0} -> Point{x_value=2, y_value=0} -> Point{x_value=2, y_value=1} -> Point{x_value=2, y_value=2} -> Point{x_value=2, y_value=3} -> ";
        String listString = pointsListA1.print();
        Assert.assertEquals(expectedValuePointsA1, listString);


        /***             Constraints List             ***/
        /* valid values */
        String expectedValueConstraint = "Constraint{agentID=1, constraintPoint=Point{x_value=2, y_value=1}, constraintTime=2} -> ";
        String listStringConstraint = constraintList.print();
        Assert.assertEquals(listStringConstraint, expectedValueConstraint);
    }



}
