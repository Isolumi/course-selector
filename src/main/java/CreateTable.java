import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.EncryptionConfiguration;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

public class CreateTable {
    public static void main(String[] args) {
        String datasetName = "course_selector";
        String tableName = "courses_table";
        Schema schema = Schema.of(
                Field.newBuilder("courseName", StandardSQLTypeName.STRING).setMode(Field.Mode.REQUIRED).build(),
                Field.newBuilder("courseID", StandardSQLTypeName.STRING).setMode(Field.Mode.REQUIRED).build(),
                Field.newBuilder("breadth", StandardSQLTypeName.STRING).setMode(Field.Mode.REQUIRED).build()
        );
        createTable(datasetName, tableName, schema);
    }

    public static void createTable(String datasetName, String tableName, Schema schema) {
        try {
            // Initialize client that will be used to send requests. this client only needs to created
            // once, and can be reused for multiple requests.
            BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();

            TableId tableId = TableId.of(datasetName, tableName);
            TableDefinition tableDefinition = StandardTableDefinition.of(schema);
            TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();

            bigQuery.create(tableInfo);
            System.out.println("Table created successfully");
        } catch (BigQueryException e) {
            System.out.println("Table was not created. \n" + e.toString());
        }
    }
}
