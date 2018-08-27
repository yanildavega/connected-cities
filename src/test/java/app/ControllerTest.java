package app;

/**
 * Created by yanildamartinez on 8/26/18.
 */

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import controller.AppController;
import domain.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AppController.class)

public class ControllerTest {


        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private Request request;


        @Test
        public void shouldReturnHelloWorld() throws Exception {
                mockMvc.perform(get("/connected?city1=Newark&city2=Boston"))
                        .andExpect(content().string("true"))
                        .andExpect(status().is2xxSuccessful());
        }

}