package io.rynartisan.pencil;

import io.rynartisan.pencil.counting.CountController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Seems like you have to annotate the tests as mvc tests?
@WebMvcTest(CountController.class) // You can pass which class this test is for?
@AutoConfigureRestDocs(outputDir = "target/docs/counting") // Directory where to output the adoc files.
public class CounterTest {

    @Autowired
    private MockMvc mockMvc; // Seems like field autowiring is allowed in test classes!!

    @Test
    public void shouldCount() throws Exception {
        this.mockMvc.perform(get("/count"))
                .andDo(print()) // Print is referenced from mockmvc, static so it can be used without referring to the object.
                .andExpect(status().isOk()) // Assert is okay, u okay status?
                .andExpect(jsonPath("count").isNumber())
                .andDo(document("count")); // Name of the method in the controller?
    }
}
