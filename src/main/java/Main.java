import com.google.cloud.bigquery.*;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        // Initialize the BigQuery service
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        // Define the query
        String query = "SELECT name, COUNT(*) as count FROM `bigquery-public-data.usa_names.usa_1910_current` GROUP BY name ORDER BY count DESC LIMIT 10";

        // Execute the query
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        TableResult result = bigquery.query(queryConfig);

        // Print the results
        System.out.printf("Top 10 most common names in the US (1910-2020):%n");
        for (FieldValueList row : result.iterateAll()) {
            String name = row.get("name").getStringValue();
            long count = row.get("count").getLongValue();
            System.out.printf("%s: %d%n", name, count);
        }
    }
}