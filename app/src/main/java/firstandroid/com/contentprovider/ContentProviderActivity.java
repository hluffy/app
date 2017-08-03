package firstandroid.com.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import firstandroid.com.R;
import firstandroid.com.object.StudentsProvider;

/**
 * Created by carol on 2017-08-03.
 */

public class ContentProviderActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentprovider);
    }

    public void onClickAddName(View view){
        ContentValues values = new ContentValues();
        EditText editText2 = (EditText)findViewById(R.id.editText);
        values.put(StudentsProvider.NAME,editText2.getText().toString());
        EditText editText3 = (EditText)findViewById(R.id.editText3);
        values.put(StudentsProvider.GRADE,editText3.getText().toString());
        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI,values);
        Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view){
        String URL = "content://com.example.provider.College/students";
        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students,null,null,null,"name");
        if(c.moveToFirst()){
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            }while (c.moveToNext());
        }

    }
}
