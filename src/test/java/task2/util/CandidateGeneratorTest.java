package task2.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CandidateGeneratorTest {

    private CandidateGenerator cg;

    @BeforeEach
    void setup() {
        cg = new CandidateGenerator();
    }

    @Test
    void generatedListSizeTest() {
        assertThat(cg.generate(), hasSize(100));
    }

    @Test
    void generateReturnsNotNullTest() {
        assertNotNull(cg.generate());
    }

}