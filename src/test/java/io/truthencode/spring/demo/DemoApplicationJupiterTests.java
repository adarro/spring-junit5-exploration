package io.truthencode.spring.demo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("JUnit 5 Proof")
public class DemoApplicationJupiterTests {

    @DisplayName("This test is fancy!!!")
    @Test
    void fancyTests() {

    }
}
