package accurest

import com.ofg.twitter.places.accurest.BaseMockMvcSpec
import groovy.json.JsonSlurper

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*

class PairId extends BaseMockMvcSpec {

	def colleratePlacesFromTweet() {
		given:
			def request = given()
					.header('Content-Type', 'application/vnd.com.ofg.twitter-places-analyzer.v1+json')
					.body('[{"created_at":"Sat Jul 26 09:38:57 +0000 2014","id":492967299297845248,"id_str":"492967299297845248","place":{"attributes":{},"bounding_box":{"coordinates":[[[-77.119759,38.791645],[-76.909393,38.791645],[-76.909393,38.995548],[-77.119759,38.995548]]],"type":"Polygon"},"country":"United States","country_code":"US","full_name":"Washington, DC","id":"01fbe706f872cb32","name":"Washington","place_type":"city","url":"http://api.twitter.com/1/geo/id/01fbe706f872cb32.json"},"text":"Gonna see you at Warsaw"}]')

		when:
			def response = given().spec(request)
					.put("/api/12")

		then:
			response.statusCode == 200
	}

}
