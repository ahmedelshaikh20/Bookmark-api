package com.ahmed.bookmarker_api;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
  "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///demo"
})
public class BookmarkControllerTest {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void shouldGetBookmarks() throws Exception {
    ResponseEntity<String> response = restTemplate.getForEntity("/api/bookmarks", String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    DocumentContext document = JsonPath.parse(response.getBody());
    Integer totalAmount = document.read("$.totalElements");
    assertThat(totalAmount).isEqualTo(3);


  }

}
