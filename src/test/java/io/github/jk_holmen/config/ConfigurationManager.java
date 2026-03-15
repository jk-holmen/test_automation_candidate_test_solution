package io.github.jk_holmen.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Singleton that provides access to test configuration from
 * {@code config.properties}.
 *
 * <p>
 * Loads properties once via {@link #getInstance()}. All configuration values
 * should be retrieved through this class.
 *
 * @author jk-holmen
 */
public class ConfigurationManager {

    private static ConfigurationManager instance;
    private final Properties properties = new Properties();

    /**
     * Loads {@code config.properties} from the classpath.
     *
     * @throws RuntimeException if the properties file cannot be found or read
     */
    private ConfigurationManager() {
        loadProperties();
    }

    /**
     * Returns the singleton instance, created when first called.
     *
     * @return the shared {@code ConfigurationManager} instance
     */
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    /**
     * Loads all properties from {@code config.properties} on the classpath.
     */
    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    /**
     * Retrieves a property value by its label.
     *
     * @param propertyLabel the property key to look up
     * @return the property value
     * @throws IllegalArgumentException if no property exists for the given label
     */
    private String get(String propertyLabel) {
        String property = properties.getProperty(propertyLabel);

        if (property == null) {
            throw new IllegalArgumentException(
                    "No property configured for label: " + propertyLabel);
        }
        return property;
    }

    /**
     * Returns the base URL for the API being tested.
     *
     * @return the base URL
     * @throws IllegalArgumentException if {@code base.url} is not configured
     */
    public String getBaseUrl() {
        return get("base.url");
    }

    /**
     * Returns the dataset ID for the given dataset name
     * ({@code dataset.id.<name>}).
     *
     * @param datasetName the dataset name from the property
     * @return the dataset ID
     * @throws IllegalArgumentException if the dataset ID is not configured
     */
    public String getDatasetId(String datasetName) {
        return get("dataset.id." + datasetName);
    }

    /**
     * Returns the connection timeout to be used when creaing an HttpClient with
     * {@link io.github.jk_holmen.clients.BaseClient#BaseClient()
     * BaseClient}.
     * 
     * @return the connection timeout time in seconds
     */
    public Long getConnectionTimeout() {
        return Long.parseLong(get("connection.timeout"));
    }

    /**
     * Returns the response timeout to be used when making HTTP requests with
     * {@link io.github.jk_holmen.clients.BaseClient#get(String).
     * 
     * @return the response timeout in seconds
     */
    public Long getResponseTimeout() {
        return Long.parseLong(get("response.timeout"));
    }
}
