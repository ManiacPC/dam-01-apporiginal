package cl.inacap.miaplicacionoriginal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private Button btnSaludar;
    private ToggleButton tBtnTest;
    private TextView tvToggleButton;
    private CheckBox cbTest;
    private TextView tvCheckBox;
    private RadioButton rbTest1;
    private RadioButton rbTest2;
    private TextView tvRadio;
    private Switch swTest;
    private TextView tvSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* SECCION PRIMERA PARTE, BOTTON CON SALUDO TOAST */
        etNombre = (EditText) findViewById(R.id.etNombre);
        btnSaludar = (Button) findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                Toast.makeText(getApplicationContext(), "Hola " + nombre, Toast.LENGTH_SHORT).show();
            }
        });

        /* SECCION TOGGLE BUTTON */
        tBtnTest = (ToggleButton) findViewById(R.id.tBtnTest);
        tvToggleButton = (TextView) findViewById(R.id.tvToggleButton);

        tBtnTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvToggleButton.setText("Activado");
                } else {
                    tvToggleButton.setText("Desactivado");
                }
            }
        });
    }

    /* SECCIÓN CHECKBOX */
    public void onCheckboxClicked(View view) {
        // Verificar estado de checkbox
        cbTest = (CheckBox) findViewById(R.id.cbTest);
        tvCheckBox = (TextView) findViewById(R.id.tvCheckBox);

        boolean checked = cbTest.isChecked();

        if (checked) tvCheckBox.setText("Activado");
        else tvCheckBox.setText("Desactivado");
    }

    /* SECCIÓN DE RADIOS */
    public void onRadioClicked(View view) {
        tvRadio = (TextView) findViewById(R.id.tvRadio);

        // El botón que llamó al método, ¿está seleccionado?
        boolean checked = ((RadioButton) view).isChecked();

        // Selección según el radio que llegó al método
        switch(view.getId()) {
            case R.id.rbTest1:
                if (checked) tvRadio.setText("Opción 1 elegida");
                break;
            case R.id.rbTest2:
                if (checked) tvRadio.setText("Opción 2 elegida");
                break;
        }
    }

    /* SWITCH */
    public void onSwitchClicked(View view)
    {
        swTest = (Switch) findViewById(R.id.swTest);
        tvSwitch = (TextView) findViewById(R.id.tvSwitch);

        Boolean checked = swTest.isChecked();
/*        if(checked) {
            tvSwitch.setText("Activado");
        } else {
            tvSwitch.setText("Desactivado");
        }*/

/*        if(checked) tvSwitch.setText("Activado");
        else tvSwitch.setText("Desactivado");*/
/*        String resultado;
        resultado = (checked) ? "Activado" : "Desactivado";
        tvSwitch.setText(resultado);*/

        tvSwitch.setText((checked) ? "Activado" : "Desactivado");
    }
}
