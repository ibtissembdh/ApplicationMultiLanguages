package com.example.multilanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

  TextView output;
  Button button;
  TextView source;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = this.findViewById(R.id.output);

        button = this.findViewById(R.id.button);

        source = this.findViewById(R.id.source);
        source.setOnClickListener(v ->openWebViewPage());


    }

    public void openWebViewPage() {
        Intent intent= new Intent(this, MainActivity2.class);
        startActivity(intent);


    }





    //create the menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
     public void translate(String lang)
     {
         Locale myLocale = new Locale(lang);
         Locale.setDefault(myLocale);// choisir locale par défaut
         Configuration config = new Configuration();// récupérer la configuration
         config.locale = myLocale; // choisir la configuration locale

         // Mettre à jour la configuration
         Resources ressources=this.getResources();
         ressources.updateConfiguration(config, ressources.getDisplayMetrics());
         // Mettre à jour le texte selon la nouvelle option
         output.setText(R.string.text);// avec : view est élément de l’interface
         // R.string.text est une ressource string

     }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
        switch (item.getItemId()) {
            case R.id.enItem:
                translate("en"); return true;
            case R.id.frItem:
                translate("fr"); return true;
            case R.id.arItem:
                translate( "ar"); return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Contextuel menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo  menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);

    }

    @SuppressLint("NonConstantResourceId")
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Item1:
                output.setTextAppearance(this,R.style.style1); return true;
            case R.id.Item2:
                output.setTextAppearance(this,R.style.style2); return true;
            case R.id.Item3:
                output.setTextAppearance(this,R.style.style3); return true;
            default: return super.onOptionsItemSelected(item);
        }
    }





}