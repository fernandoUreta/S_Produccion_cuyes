package com.example.proyectocuy.Controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;
import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Poza;
import com.example.proyectocuy.ModeloDatos.Transaccion;
import com.example.proyectocuy.R;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;
import com.example.proyectocuy.Tools.Transacciones;
import com.google.android.material.textfield.TextInputEditText;

public class RegistroIngresoCuyesPozasActivity extends AppCompatActivity {

    Spinner spTipoIngreso, spCategoria, spGenero;
    TextView tvCantidadCuyes1, tvCantidadCuyes2, tvCantidadCuyes3;
    TextView tvDesc1, tvDesc2, tvDesc3,tvTipoPoza,tvIdPoza;
    TextInputEditText txtCodigo, txtEdad;
    EditText etEdadCuy,etCodigoCuy;

    Transaccion transaccion=new Transaccion();
    String[]generos;
    String[]tiposCuy;
    Poza poza=new Poza();

    //Datos provenientes del disparador
    String idUsuario="70771304";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ingreso_cuyes_pozas);
        showToolbar("Ingreso de cuyes",true);

        //Asignacion
        spTipoIngreso=findViewById(R.id.spTipoIngreso);
        spCategoria=findViewById(R.id.spCategoria);
        spGenero=findViewById(R.id.spGenero);

        etEdadCuy=findViewById(R.id.etEdadCuy);
        etCodigoCuy=findViewById(R.id.etCodigoCuy);

        tvCantidadCuyes1 =(TextView) findViewById(R.id.tvCantidadCuy1);
        tvCantidadCuyes2 =(TextView)findViewById(R.id.tvCantidadCuy2);
        tvCantidadCuyes3 =(TextView)findViewById(R.id.tvCantidadCuy3);

        txtCodigo=(TextInputEditText)findViewById(R.id.etCodigoCuy);
        txtEdad=(TextInputEditText)findViewById(R.id.etEdadCuy);

        tvDesc1=(TextView)findViewById(R.id.tvDescCategoria1);
        tvDesc2=(TextView)findViewById(R.id.tvDescCategoria2);
        tvDesc3=(TextView)findViewById(R.id.tvDescCategoria3);
        tvTipoPoza=(TextView)findViewById(R.id.tvTipoPoza);
        tvIdPoza=(TextView)findViewById(R.id.tvIdPoza);

        ArrayAdapter<CharSequence> adapterTipoIngreso = ArrayAdapter.createFromResource(this, R.array.tipoIngresoCuy,R.layout.spinner_formato);
        spTipoIngreso.setAdapter(adapterTipoIngreso);

        Bundle pozaRecibida=getIntent().getExtras();
        if(pozaRecibida!=null)
        {
            poza= (Poza) pozaRecibida.getSerializable("poza");
        }
        String tipoPoza="";
        try {
            if(poza.getIdPoza().contains("A"))
            { tipoPoza="Empadre";}
            else if (poza.getIdPoza().contains("B"))
            { tipoPoza="Engorde"; }
            else if(poza.getIdPoza().contains("C"))
            { tipoPoza="Recría"; }
            else if(poza.getIdPoza().contains("D"))
            { tipoPoza="Padrillo"; }

            poza.setClasificacion(tipoPoza);
            tvIdPoza.setText(poza.getIdPoza());
            adaptarInterfaz(poza);

            spCategoria.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_formato,tiposCuy));
        }catch (Exception e){
            Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_LONG).show();
        }

        spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                spGenero.setAdapter(null);
                Toast.makeText(getApplicationContext(),"Holi",Toast.LENGTH_SHORT).show();
                if(spCategoria.getSelectedItem().toString().equals("Madre madura")||spCategoria.getSelectedItem().toString().equals("Madre primeriza"))
                {
                    //generos=null;
                    generos=new String[1];
                    generos[0]="Hembra";
                }
                else if (spCategoria.getSelectedItem().toString().equals("Padrillo")){
                    //generos=null;
                    generos=new String[1];
                    generos[0]="Macho";
                }else {
                    //generos=null;
                    generos=new String[2];
                    generos[0]="Macho";
                    generos[1]="Hembra";
                }
                spGenero.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_formato,generos));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }



    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Transacciones.destruirTransaccion(transaccion.getIdTransaccion());
    }
    @Override
    protected void onStop() {
        super.onStop();
        Transacciones.destruirTransaccion(transaccion.getIdTransaccion());
    }
    @Override
    public void onResume(){
        super.onResume();
        transaccion= Transacciones.generarTransaccion(idUsuario);
    }

    public void btnAgregarClick(View view)
    {
        if (validarCampos()==true)
        {
            Transacciones.RegistrarEntradaCuyes(capturarCuy(),transaccion,spTipoIngreso.getSelectedItem().toString(),this);
            adaptarInterfaz(poza);
            restablecerCampos();
        }else {};
    }
    public boolean validarCampos()
    {
        if(TextUtils.isEmpty(etEdadCuy.getText().toString().trim())||TextUtils.isEmpty(etCodigoCuy.getText().toString().trim()))
        {
            Toast.makeText(this,"Ingrese los valores solicitados",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }
    private Cuy capturarCuy()
    {
        Cuy cuy=new Cuy();
        cuy.setCuyId(etCodigoCuy.getText().toString());
        cuy.setIdPoza(tvIdPoza.getText().toString());
        switch (spCategoria.getSelectedItem().toString())
        {
            case "Madre madura":cuy.setCategoria("MM");break;
            case "Madre primeriza":cuy.setCategoria("MP");break;
            case "Padrillo":cuy.setCategoria("PD");break;
            case "Engorde":cuy.setCategoria("EG");break;
            case "Recria":cuy.setCategoria("RC");break;
            case "Lactante":cuy.setCategoria("LC");break;
        }
        cuy.setGenero(spGenero.getSelectedItem().toString());
        cuy.setFechaNaci(Fechas.calcularFechaNacimiento(Integer.parseInt(txtEdad.getText().toString())));

        return cuy;
    }

    private void restablecerCampos()
    {
        etCodigoCuy.setText("");
        etEdadCuy.setText("");
    }

    private void adaptarInterfaz(Poza poza) {
        try {
            //
            tvTipoPoza.setText(poza.getClasificacion());

            tvDesc1.setVisibility(View.INVISIBLE);
            tvCantidadCuyes1.setVisibility(View.INVISIBLE);

            tvDesc2.setVisibility(View.INVISIBLE);
            tvCantidadCuyes2.setVisibility(View.INVISIBLE);

            tvDesc3.setVisibility(View.INVISIBLE);
            tvCantidadCuyes3.setVisibility(View.INVISIBLE);

            switch (poza.getClasificacion())
            {
                case "Empadre": {

                    tvDesc1.setText("Madres");
                    int val= BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"MM")+BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"MP");
                    tvCantidadCuyes1.setText(String.valueOf(val));
                    tvDesc2.setText("Padrillos");
                    tvCantidadCuyes2.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"PD")));
                    tvDesc3.setText("Lactantes");
                    tvCantidadCuyes3.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"LC")));
                    tiposCuy=new String[4];

                    this.tiposCuy[0]="Madre madura";
                    this.tiposCuy[1]="Madre primeriza";
                    this.tiposCuy[2]="Padrillo";
                    this.tiposCuy[3]="Lactante";


                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    tvDesc2.setVisibility(View.VISIBLE);
                    tvCantidadCuyes2.setVisibility(View.VISIBLE);
                    tvDesc3.setVisibility(View.VISIBLE);
                    tvCantidadCuyes3.setVisibility(View.VISIBLE);
                }break;

                case "Padrillo":{
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvDesc1.setText("Padrillos");
                    tvCantidadCuyes1.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"PD")));
                    tiposCuy=new String[1];
                }break;

                //To analizar
                case "Recría":{
                    tvDesc1.setText("Cuyes");
                    tiposCuy=new String[1];
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    int total=BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"RC");
                    tvCantidadCuyes1.setText(String.valueOf(total));

                    this.tiposCuy[0]="Recria";
                }break;
                //

                case "Recría Macho":{
                    tvDesc1.setText("Machos");
                    tiposCuy=new String[1];
                    tvCantidadCuyes1.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"RC")));
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    this.tiposCuy[0]="Recria";

                }break;
                case "Recría Hembra":{
                    tvDesc1.setText("Hembras");
                    tiposCuy=new String[1];
                    tvCantidadCuyes1.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"RC")));
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    this.tiposCuy[0]="Recria";
                }break;
                case "Engorde Macho":{
                    tvDesc1.setText("Machos");
                    tvCantidadCuyes1.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"EG")));
                    tiposCuy=new String[1];
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    this.tiposCuy[0]="Engorde";
                }break;
                case "Engorde Hembra":{
                    tvDesc1.setText("Hembras engorde");
                    tvCantidadCuyes1.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"EG")));
                    tiposCuy=new String[1];
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    this.tiposCuy[0]="Engorde";
                }break;
                //Analizar
                case "Engorde":{
                    tvDesc1.setText("Cuyes");
                    tiposCuy=new String[1];
                    tvCantidadCuyes1.setText(String.valueOf(BD_AccesoDatos.consultarCantiTipoCuyPoza(poza.idPoza,"EG")));
                    tvDesc1.setVisibility(View.VISIBLE);
                    tvCantidadCuyes1.setVisibility(View.VISIBLE);
                    this.tiposCuy[0]="Engorde";
                }break;
            }

        }catch (Exception e)
        {
            Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_LONG).show();
        }


    }
}