package sergey_katsapov.shared_preferences_tutorial;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;
    EditText editText;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(String.valueOf(R.string.DATA), MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
        editText = findViewById(R.id.data);
    }

    /**
     * class for working with shared preferences - SAVE
     *
     * @param view
     * @autor Katsapov Sergey
     */
    public void saveToSharedPreferences(View view) {
        sharedPreferencesEditor.putString(String.valueOf(R.string.DATA), editText.getText().toString());
        sharedPreferencesEditor.commit();
        String sharedPreferencesData = sharedPreferences.getString(String.valueOf(R.string.DATA), "");
        Toast.makeText(MainActivity.this, "Saved data is: " + sharedPreferencesData, Toast.LENGTH_SHORT).show();

    }

    /**
     * class for working with shared preferences - DELETE
     *
     * @param view
     * @autor Katsapov Sergey
     */
    public void deleteFromSharedPreferences(View view) {
        sharedPreferencesEditor.remove(String.valueOf(R.string.DATA));
        sharedPreferencesEditor.commit();
    }

    /**
     * class for working with shared preferences - SHOW
     *
     * @param view
     * @autor Katsapov Sergey
     */
    public void showDataFromSharedPreferences(View view) {
        String sharedPreferencesData = sharedPreferences.getString(String.valueOf(R.string.DATA), "");
        Toast.makeText(MainActivity.this, "Saved data is:" + sharedPreferencesData, Toast.LENGTH_SHORT).show();
    }
}