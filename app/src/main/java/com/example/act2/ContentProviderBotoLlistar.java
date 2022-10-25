package com.example.act2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContentProviderBotoLlistar extends AppCompatActivity {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/M8_1.2";
    private static final String user = "hvallve";
    private static final String pass = "He123";
    Button btnFetch, btnClear;
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Botons per crear la connexio i poder llistar la BD o borrar-la
         */
//        setContentView(R.layout.content_acces_bd); Afegir el nom de la clase per fer les consultes
//        txtData = (TextView) this.findViewById(R.id.txtData);
//        btnFetch = (Button) findViewById(R.id.btnFetch);
//        btnClear = (Button) findViewById(R.id.btnClear);
//        @Override
//        public void onClick(View v) {
//            ConnectMySql connectMySql = new ConnectMySql();
//            connectMySql.execute("");
//        }
//    });
//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtData.setText("");
//            }
//        });


    }


    private class ConnectMySql extends AsyncTask<String, Void, String>{

        String res = "";

        @Override
        protected String doInBackground(String... strings) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);

//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery("select nom from Programadors where pais like 'Estats Units'");
//
//                while (rs.next()) {
//                    result += rs.getString(1).toString() + "\n";
//                }
                String result = "Accés correcte a la BD";
                res= result;

            }catch (Exception e){
                e.printStackTrace();
                res = e.toString();
            }
            return res;
        }

        @Override
        protected void onPostExecute(String result) {
            txtData.setText(result);
        }
    }
}
