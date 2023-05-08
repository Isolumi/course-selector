import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

import java.util.ArrayList;
import java.util.List;

public class AddColumn {
    public static void main(String[] args) {
        String datasetId = "voice-interaction-platform.course_selector";
        String tableId = "voice-interaction-platform.course_selector.courses";

        // Initialize the BigQuery service
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        // Define the values for the new row
        String courseName = "Introduction to the Theory of Computation";
        String courseCode = "CSC236H1";


    }
}
