package fr.wcs.quetesimpleui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox maCheckBox = (CheckBox) findViewById(R.id.checkBox);
        maCheckBox.setOnClickListener(new View.OnClickListener() {
            EditText prenom = (EditText) findViewById(R.id.editText);
            EditText nom = (EditText) findViewById(R.id.editText2);
            Button button = (Button) findViewById(R.id.button);
            @Override public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    prenom.setEnabled(true);
                    nom.setEnabled(true);
                    button.setEnabled(true);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(prenom.getText().toString().equals("")||nom.getText().toString().equals("")){
                                Context context = getApplicationContext();
                                CharSequence text = "Tu dois reseigner le nom et le prénom !";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }else{
                                TextView affFelicitation = (TextView) findViewById(R.id.textView2);
                                affFelicitation.setText("Félicitation "+prenom.getText()+" "+nom.getText());
                                affFelicitation.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                } else {
                    prenom.setEnabled(false);
                    nom.setEnabled(false);
                    button.setEnabled(false);
                }
            }
        });
    }
}