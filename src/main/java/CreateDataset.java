import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;

public class CreateDataset {
    public static void main(String[] args) {
        String datasetName = "course_selector";
        createDataset(datasetName);
    }

    public static void createDataset(String datasetName) {
        try {
            // Initialize client that will be used to send requests. This client only needs to be created once, and can be reused for multiple requests.
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

            String location = "northamerica-northeast2";

            DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).setLocation(location).build();

            Dataset newDataset = bigquery.create(datasetInfo);
            String newDatasetName = newDataset.getDatasetId().getDataset();
            String a = newDataset.getDatasetId().getProject();
            System.out.println(newDatasetName + " created sucessfully" + a);

        } catch (BigQueryException e) {
            System.out.println("Dataset was not created. \n" + e.toString());
        }
    }
}
