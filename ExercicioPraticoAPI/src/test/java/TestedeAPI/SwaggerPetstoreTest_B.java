package TestedeAPI;

//bibliotecas
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //garante ordem dos testes por nome
public class SwaggerPetstoreTest_B {
	
	//A partir de uma massa de teste elaborada por voc�, crie 5 usu�rios e 10 pets (5 dogs e 5 cats)
	
	@Test //cria uma lista de usu�rios
	public void test6A_Criar5Usuarios() {
		given()
		.contentType("application/json")
			.body("[  {\"id\": 2, \"username\": \"luizantonio\", \"firstName\": \"Luiz\", \"lastName\": \"Antonio\", \"email\": \"luizantonio@iterasystest.com\",\"password\": \"test123\", \"phone\": \"11976340001\", \"userStatus\": 1},"
					+ "{\"id\": 3, \"username\": \"luiznunes\", \"firstName\": \"Luiz\", \"lastName\": \"Nunes\", \"email\": \"luiznunes@iterasystest.com\",\"password\": \"test123\", \"phone\": \"11976340002\", \"userStatus\": 1},"
					+ "{\"id\": 4, \"username\": \"luizneves\", \"firstName\": \"Luiz\", \"lastName\": \"Neves\", \"email\": \"luizneves@iterasystest.com\",\"password\": \"test123\", \"phone\": \"11976340003\", \"userStatus\": 1},"
					+ "{\"id\": 5, \"username\": \"antonionunes\", \"firstName\": \"Antonio\", \"lastName\": \"Nunes\", \"email\": \"antonionunes@iterasystest.com\",\"password\": \"test123\", \"phone\": \"11976340004\", \"userStatus\": 1},"
					+ "{\"id\": 6, \"username\": \"antonioneves\", \"firstName\": \"Antonio\", \"lastName\": \"Neves\", \"email\": \"antonioneves@iterasystest.com\",\"password\": \"tet123\", \"phone\": \"11976340005\", \"userStatus\": 1} ]")
		.when()
			.post("https://petstore.swagger.io/v2/user/createWithArray")
		.then()
			.log().all()
			.statusCode(200);

	}
	
	
	@Test //cria os 10 pets 5 cats e 5 dogs
	public void test6B_Criar10Pets() {
			given()
				.contentType("application/json")
				.body("{\"id\": 11, \"category\": {\"id\": 0, \"name\": \"Dog\"},\"name\": \"Tot�\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
		
			given()
				.contentType("application/json")
				.body("{\"id\": 12, \"category\": {\"id\": 0, \"name\": \"Dog\"},\"name\": \"Pingo\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
			
			given()
				.contentType("application/json")
				.body("{\"id\": 13, \"category\": {\"id\": 0, \"name\": \"Dog\"},\"name\": \"Lola\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);

			given()
				.contentType("application/json")
				.body("{\"id\": 14, \"category\": {\"id\": 0, \"name\": \"Dog\"},\"name\": \"Belinha\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);

			given()
				.contentType("application/json")
				.body("{\"id\": 15, \"category\": {\"id\": 0, \"name\": \"Dog\"},\"name\": \"Rex\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
			
			given()
				.contentType("application/json")
				.body("{\"id\": 16, \"category\": {\"id\": 1, \"name\": \"Cat\"},\"name\": \"Tomaz\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
			
			given()
				.contentType("application/json")
				.body("{\"id\": 17, \"category\": {\"id\": 1, \"name\": \"Cat\"},\"name\": \"Frodo\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
			
			given()
				.contentType("application/json")
				.body("{\"id\": 18, \"category\": {\"id\": 1, \"name\": \"Cat'\"},\"name\": \"Bilu\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
			
			given()
				.contentType("application/json")
				.body("{\"id\": 19, \"category\": {\"id\": 1, \"name\": \"Cat\"},\"name\": \"Bixano\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);

			given()
				.contentType("application/json")
				.body("{\"id\": 20, \"category\": {\"id\": 1, \"name\": \"Cat\"},\"name\": \"Elvis\",\"status\": \"available\"}")
			.when()
				.post("https://petstore.swagger.io/v2/pet")
			.then()
				.log().all()
				.statusCode(200);
	}
	
	
	
	@Test //Fa�a a venda de 1 dog e 1 cat para cada usu�rio
	public void test7_FacaVendaPets() { 
		//fazer a venda dos pets
		given()
			.contentType("application/json")
			.body("{\"id\": 1,\"petId\": 11,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:15:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")			
			.body("{\"id\": 2,\"petId\": 12,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:16:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")	
	    	.body("{\"id\": 3,\"petId\": 13,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:17:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
    	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
	
		given()
			.contentType("application/json")
	    	.body("{\"id\": 4,\"petId\": 14,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:18:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
    	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
    
		given()
			.contentType("application/json")	
	    	.body("{\"id\": 5,\"petId\": 15,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:19:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
    	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
    	
		given()
			.contentType("application/json")
	       	.body("{\"id\": 6,\"petId\": 16,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:20:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
       	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
		
       	given()
			.contentType("application/json")
	        .body("{\"id\": 7,\"petId\": 17,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:21:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
        .when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
        
		given()
			.contentType("application/json")
	        .body("{\"id\": 8,\"petId\": 18,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:22:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
        .when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);   
	    
	   given()
			.contentType("application/json")
	        .body("{\"id\": 9,\"petId\": 19,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:23:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
	   .when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);	
	   
		given()
			.contentType("application/json")
	        .body("{\"id\": 10,\"petId\": 20,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:24:03.596+0000\", \"status\": \"placed\",\"complete\": true}")
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.statusCode(200);
		
		//Para cada usuario 2 animais 2 dog e um cat
		given()
			.contentType("application/json")
			.body("{\"id\": 11, \"tags\": [{\"id\":2, \"name\":\"Luiz Antonio\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")
			.body("{\"id\": 16, \"tags\": [{\"id\":2, \"name\":\"Luiz Antonio\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")
			.body("{\"id\": 12, \"tags\": [{\"id\":3, \"name\":\"Luiz Nunes\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
		.contentType("application/json")
		.body("{\"id\": 17, \"tags\": [{\"id\":3, \"name\":\"Luiz Nunes\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")
			.body("{\"id\": 13, \"tags\": [{\"id\":4, \"name\":\"Luiz Neves\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")
			.body("{\"id\": 18, \"tags\": [{\"id\":4, \"name\":\"Luiz Neves\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")
			.body("{\"id\": 14, \"tags\": [{\"id\":5, \"name\":\"Antonio Nunes\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")
			.body("{\"id\": 19, \"tags\": [{\"id\":5, \"name\":\"Antonio Nunes\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);		
					
		given()
			.contentType("application/json")
			.body("{\"id\": 15, \"tags\": [{\"id\":6, \"name\":\"Antonio Neves\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")
			.body("{\"id\": 20, \"tags\": [{\"id\":6, \"name\":\"Antonio Neves\"}],\"status\": \"sold\"}")
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	
	
	@Test //Mude o status das ordens de venda de dogs para "delivered" e de cats para "approved"
	public void test8_MudaStatusVenda() { 
		//fazer a venda dos pets
		given()
			.contentType("application/json")
			.body("{\"id\": 1,\"petId\": 11,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:25:03.596+0000\", \"status\": \"delivered\",\"complete\": true}")
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("delivered"))
			.statusCode(200);
		
		given()
			.contentType("application/json")			
			.body("{\"id\": 2,\"petId\": 12,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:26:03.596+0000\", \"status\": \"delivered\",\"complete\": true}")
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("delivered"))
			.statusCode(200);
			
		given()
			.contentType("application/json")	
	    	.body("{\"id\": 3,\"petId\": 13,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:27:03.596+0000\", \"status\": \"delivered\",\"complete\": true}")
    	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("delivered"))
			.statusCode(200);
	
		given()
			.contentType("application/json")
	    	.body("{\"id\": 4,\"petId\": 14,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:28:03.596+0000\", \"status\": \"delivered\",\"complete\": true}")
    	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("delivered"))
			.statusCode(200);
    
		given()
			.contentType("application/json")	
	    	.body("{\"id\": 5,\"petId\": 15,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:29:03.596+0000\", \"status\": \"delivered\",\"complete\": true}")
    	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("delivered"))
			.statusCode(200);
    	
		given()
			.contentType("application/json")
	       	.body("{\"id\": 6,\"petId\": 16,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:30:03.596+0000\", \"status\": \"approved\",\"complete\": true}")
       	.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("approved"))
			.statusCode(200);
		
       	given()
			.contentType("application/json")
	        .body("{\"id\": 7,\"petId\": 17,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:31:03.596+0000\", \"status\": \"approved\",\"complete\": true}")
        .when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("approved"))
			.statusCode(200);
        
		given()
			.contentType("application/json")
	        .body("{\"id\": 8,\"petId\": 18,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:32:03.596+0000\", \"status\": \"approved\",\"complete\": true}")
        .when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("approved"))
			.statusCode(200); 
	    
	   given()
			.contentType("application/json")
	        .body("{\"id\": 9,\"petId\": 19,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:33:03.596+0000\", \"status\": \"approved\",\"complete\": true}")
	   .when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("approved"))
			.statusCode(200);	
	   
		given()
			.contentType("application/json")
	        .body("{\"id\": 10,\"petId\": 20,\"quantity\": 1,\"shipDate\": \"2020-12-05T13:34:03.596+0000\", \"status\": \"approved\",\"complete\": true}")
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.log().all()
			.body("status", containsString("approved"))
			.statusCode(200);
		}
	
	@Test //onsulte as ordens geradas e valide se est�o corretas
 	public void test9_ConsultarOrdensDeVenda() {
		
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/1")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/2")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/3")
		.then()
			.log().all()
			.statusCode(200);
		
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/4")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/5")
		.then()
			.log().all()
			.statusCode(200);
			
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/6")
		.then()
			.log().all()
			.statusCode(200);

		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/7")
		.then()
			.log().all()
			.statusCode(200);

		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/8")
		.then()
			.log().all()
			.statusCode(200);

		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/9")
		.then()
			.log().all()
			.statusCode(200);
	
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/store/order/10")
		.then()
			.log().all()
			.statusCode(200);
	}

}
	

