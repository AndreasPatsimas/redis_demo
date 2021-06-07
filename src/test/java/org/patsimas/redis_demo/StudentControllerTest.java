package org.patsimas.redis_demo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.patsimas.redis_demo.domain.Student;
import org.patsimas.redis_demo.enums.Gender;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=StudentControllerTest",
        "spring.jmx.default-domain=StudentControllerTest"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentControllerTest extends BasicWiremockTest {

    @Test
    public void a_createStudents() throws Exception {

        Student student = Student.builder()
                .id("teers")
                .name("Andy")
                .grade(9)
                .gender(Gender.MALE)
                .build();

        this.mockMvc.perform(post("/students")
                .content(asJsonString(student))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void b_fetchStudents() throws Exception {
        this.mockMvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
