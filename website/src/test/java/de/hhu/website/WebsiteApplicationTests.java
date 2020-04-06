package de.hhu.website;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebsiteApplicationTests {

  @Test
  // This test is Spring standard and works correctly without assert
  // Method contextLoads must not be package private
  @SuppressWarnings({"PMD.JUnitTestsShouldIncludeAssert", "PMD.DefaultPackage"})
    /* default */ void contextLoads() {
  }

}


