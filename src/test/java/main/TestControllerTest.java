package main;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addMessageTest () throws Exception {

        model.Test test = new model.Test("Hello", "Tester", "Orlando", "40" );
        Gson gson = new Gson();

        this.mockMvc.perform(post("/devops")
                .contentType(MediaType.APPLICATION_JSON)
                .header("X-Parse-REST-API-Key","2f5ae96c-b558-4c7b-a590-a501ae1c3f6c")
                .content(gson.toJson(test)))
                .andExpect(status().isOk());
    }
}