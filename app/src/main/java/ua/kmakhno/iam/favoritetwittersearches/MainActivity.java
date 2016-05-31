package ua.kmakhno.iam.favoritetwittersearches;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity{

    private SharedPreferences savedSearch;
    private TableLayout queryTableLayout;
    private EditText queryEditText;
    private EditText tagEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        savedSearch = getSharedPreferences("searches", MODE_PRIVATE);

        queryTableLayout = (TableLayout)findViewById(R.id.queryTableLayout);

        queryEditText = (EditText)findViewById(R.id.queryEditText);
        tagEditText = (EditText)findViewById(R.id.tagEditText);

        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(saveButtonListener);

        Button clearButton = (Button)findViewById(R.id.clearTagsButton);
        clearButton.setOnClickListener(clearButtonListener);

        refreshButtons(null);
    }

    private void refreshButtons(String newTag) {

        String[] tags = savedSearch.getAll().keySet().toArray(new String[0]);
        Arrays.sort(tags, String.CASE_INSENSITIVE_ORDER);

        if(newTag != null){
            makeTagGUI(newTag, Arrays.binarySearch(tags, newTag));
        }
    }

    private void makeTagGUI(String query, String tag) {
    }
}
