import com.google.cloud.bigquery.*;

import java.util.HashMap;
import java.util.Map;

public class InsertRow {
    public static void main(String[] args) {
        // Set your dataset ID and table ID
        String datasetId = "course_selector";
        String tableId = "courses_table";

        // Initialize the BigQuery service
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        // Define the values for the new row
        String courseName = "Multivariable Calculus with Proofs";
        String courseID = "mat237y1";
        String courseDesc = "Elementary topology in Euclidean space. Differential calculus of vector valued functions of a vector variable. Implicit and inverse function theorems, regular surfaces. Optimization, Lagrange multipliers, multivariable Taylor polynomials. Integral calculus with the Jordan measure. Fubini’s theorem, change of variables. Line and surface integrals. Vector calculus in two- and three-dimensions. Green’s theorem, Divergence theorem, Stokes’ theorem. Fourier series. This course is recommended for students interested in proof-based multivariable calculus with balanced emphasis between theory and applications.";
        int breadth = 5;

        // Prepare the row to insert
        Map<String, Object> rowContent = new HashMap<>();
        rowContent.put("courseName", courseName);
        rowContent.put("courseID", courseID);
        rowContent.put("courseDesc", courseDesc);
        rowContent.put("breadth", breadth);
        InsertAllRequest.RowToInsert row = InsertAllRequest.RowToInsert.of(rowContent);

        // Insert the row
        InsertAllRequest insertRequest = InsertAllRequest.newBuilder(TableId.of(datasetId, tableId)).addRow(row).build();

        InsertAllResponse insertResponse = bigquery.insertAll(insertRequest);

        if (insertResponse.hasErrors()) {
            System.out.println("Error(s) occurred while inserting row:");
            insertResponse.getInsertErrors().values().forEach(System.out::println);
        } else {
            System.out.println("New row inserted.");
        }
    }
}
