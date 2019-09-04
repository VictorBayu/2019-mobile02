package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	int random;
	private EditText input_angka;
	private Button guess_button,reset_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		initRandomNumber();
		input_angka = findViewById(R.id.number_input);
		guess_button = findViewById(R.id.guess_button);
	}

	// TODO: generate angka random di sini
	private int initRandomNumber() {
		Random r = new Random();
		random = r.nextInt(100);
		return random;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int number = Integer.parseInt(String.valueOf(input_angka.getText()));
		if (number > random){
			Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
		}else if (number < random){
			Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
		}else {
			guess_button.setEnabled(false);
			Toast.makeText(this, "Tebakan anda benar", Toast.LENGTH_SHORT).show();
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		input_angka.setText("");
		guess_button.setEnabled(true);
	}
}
