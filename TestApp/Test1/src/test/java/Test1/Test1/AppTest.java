package Test1.Test1;

import static org.junit.Assert.*;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void validateThatNavigatingToHomePageShouldReturn200OKAndHomePageIsPopulated()
    {
        RestAssured.given().
					when().
			        get("http://127.0.0.1:5000").
					then().
					statusCode(200).
					and().
					body("html.body.div.h1", Matchers.equalTo("Calculating Paint Required"));
    }
    
    @Test
    public void validateThatNavigatingToDimensionPageFromHomeReturnsCorrectAmountOfRowsForEnteringRoomDimensions_Test1_FunctionalTest()
    {
    	int totalRooms = 5;
    	
    	/*
    	Print statement for debugging purpose
    	System.out.println(
			RestAssured.given().
						when().
				        get("http://127.0.0.1:5000/dimensions?rooms={totalRooms}",totalRooms).
						then().
						extract().
						response().asString());
    	*/
    	
    	RestAssured.given().
					when().
			        get("http://127.0.0.1:5000/dimensions?rooms={totalRooms}",totalRooms).
					then().
					statusCode(200).
					and().
					body("html.body.div.form.table.tr.size()", Matchers.equalTo(totalRooms+1));
    }
    
    @Test
    public void validateThatNavigatingToDimensionPageFromHomeReturnsCorrectAmountOfRowsForEnteringRoomDimensions_Test2_CheckBelowLimit_BadRequest()
    {
    	int totalRooms = -1;
  
    	/*
	   	Print statement for debugging purpose
    	System.out.println(
			RestAssured.given().
						when().
				        get("http://127.0.0.1:5000/dimensions?rooms={totalRooms}",totalRooms).
						then().
						extract().
						response().asString());
    	*/
    	
    	RestAssured.given().
					when().
			        get("http://127.0.0.1:5000/dimensions?rooms={totalRooms}",totalRooms).
					then().
					statusCode(200).
					and().
					body("html.body.div.form.table.tr.size()", Matchers.equalTo(1));
    }
    
    @Test
    public void validateThatNavigatingToResultPageFromDimensionsPage_Test1_FunctionalTest()
    {
    	int length = 5, width = 5, height = 5;
  
//    	Print statement for debugging purpose
//    	System.out.println(
//			RestAssured.given().
//						params("length-0", 5).
//	    				params("width-0", 5).
//	    				params("height-0", 5).
//						when().
//				        post("http://127.0.0.1:5000/results").
//						then().
//						extract().
//						response().asString());
    	
    	String htmlContent = RestAssured.given().
			    						params("length-0", length).
			    	    				params("width-0", width).
			    	    				params("height-0", height).
			    						when().
			    				        post("http://127.0.0.1:5000/results").
			    						then().
			    						extract().
			    						response().asString();
    	
    	assertEquals(new XmlPath(CompatibilityMode.HTML,htmlContent).get("html.body.div.table.tr[1].td[1]").toString().replaceAll("\\s+",""), "100");
    	assertEquals(new XmlPath(CompatibilityMode.HTML,htmlContent).get("html.body.div.table.tr[1].td[2]").toString().replaceAll("\\s+",""), "0.0");
    	assertEquals(new XmlPath(CompatibilityMode.HTML,htmlContent).get("html.body.div.h5").toString(), "Total Gallons Required: 0.0");
    }
    
    @Test
    public void validateThatNavigatingToResultPageFromDimensionsPage_Test2_BadRequest()
    {
		RestAssured.given().
					params("length-0", 0).
    				params("width-0", 0).
    				params("height-0", 0).
					when().
			        post("http://127.0.0.1:5000/results").
			        then().
					statusCode(400);
    }
    
    @Test
    public void validateThatNavigatingToResultPageFromDimensionsPage_Test3_BadRequest()
    {
		RestAssured.given().
					params("length-0", 0).
    				params("height-0", 0).
					when().
			        post("http://127.0.0.1:5000/results").
			        then().
					statusCode(400);
    }
    
    @Test
    public void validateThatNavigatingToResultPageFromDimensionsPage_Test4_BadRequest()
    {
		RestAssured.given().
					params("width-0", 0).
    				params("height-0", 0).
					when().
			        post("http://127.0.0.1:5000/results").
			        then().
					statusCode(400);
    }
    
    @Test
    public void validateThatNavigatingToResultPageFromDimensionsPage_Test5_BadRequest()
    {
		RestAssured.given().
					params("width-0", 0).
    				params("length-0", 0).
					when().
			        post("http://127.0.0.1:5000/results").
			        then().
					statusCode(400);
    }
}
