package io.github.jk_holmen.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.jk_holmen.clients.ApiResponse;
import io.github.jk_holmen.clients.TestpersonnummerClient;
import io.github.jk_holmen.models.TestpersonnummerResponse;

/**
 * Tests for the Testpersonnummer dataset API.
 *
 * <p>
 * Validates lookup behavior for the {@code testpersonnummer} query parameter,
 * including successful matches and invalid input handling.
 *
 * @author jk-holmen
 */
class TestpersonnummerTest {
    private TestpersonnummerClient client;

    @BeforeEach
    void setUpClient() {
        client = new TestpersonnummerClient();
    }

    /**
     * A valid and existing personal number should return exactly one matching
     * record with that same number in the response body.
     */
    @Test
    @DisplayName("GET with valid personal number returns 200 and a unique match")
    public void givenPersonalNumber_whenGetByPersonalNumber_thenItShouldReturnUniqueMatchingRecord()
            throws IOException, InterruptedException {
        String personalNumber = TestData.EXISTING_PERSONNUMMER;
        int expectedCount = 1;

        ApiResponse response = client.getTestpersonnummer(personalNumber);
        assertEquals(200, response.statusCode());

        TestpersonnummerResponse tpnrResponse = response.as(TestpersonnummerResponse.class);
        assertEquals(expectedCount, tpnrResponse.getResultCount());
        assertEquals(personalNumber, tpnrResponse.getResults().get(0).getTestpersonnummer());
    }

    /**
     * An empty personal number is invalid input and should be rejected by the API.
     */
    @Test
    @DisplayName("GET with empty personal number returns 400")
    public void givenEmptyPersonalNumber_whenGetByPersonalNumber_thenItShouldReturnStatusCode400()
            throws IOException, InterruptedException {
        String personalNumber = "";

        ApiResponse response = client.getTestpersonnummer(personalNumber);
        assertEquals(400, response.statusCode());
    }
}
