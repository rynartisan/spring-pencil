package io.rynartisan.pencil;

import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

// Seems like you have to annotate the tests as mvc tests?
@WebMvcTest // You can pass which class this test is for?
@AutoConfigureRestDocs (outputDir = "target/docs/counter-api") // Directory where to output the adoc files.
public class CounterTest {

}
