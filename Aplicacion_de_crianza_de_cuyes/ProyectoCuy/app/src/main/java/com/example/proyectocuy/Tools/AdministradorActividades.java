package com.example.proyectocuy.Tools;

import android.content.Context;


import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;
import com.example.proyectocuy.ModeloDatos.Actividad;

import java.util.ArrayList;
import java.util.List;

public class AdministradorActividades {

    private List<Actividad> actividadesAll =new ArrayList<>();
    Context context;

    public AdministradorActividades(Context context) {
        this.context = context;
        rotacion_recria();
        retiro_madres();
        retiro_padrillos();
    }
    private void rotacion_recria()
    {
        String descripcion="Rotación de recría a engorde";
        //Re
        List<Actividad> activiRecria= BD_AccesoDatos.obtenerCuyesLimiteEdadEnPoza("RC","Recría",30,descripcion,context);
        actividadesAll.addAll(activiRecria);
    }
    private void retiro_madres()
    {
        String descripcion="Retiro de madres por edad máxima alcanzada";
        List<Actividad> activiMadresSalidaR=BD_AccesoDatos.obtenerCuyesLimiteEdadEnPoza("MM","Recría",550,descripcion,context);
        actividadesAll.addAll(activiMadresSalidaR);
        List<Actividad> activiMadresSalidaE=BD_AccesoDatos.obtenerCuyesLimiteEdadEnPoza("MM","Empadre",550,descripcion,context);
        actividadesAll.addAll(activiMadresSalidaE);
    }
    private void partos()
    {

    }
    private void retiro_padrillos()
    {
        String descripcion="Retiro de padrillos por edad máxima alcanzada";
        List<Actividad> activiPadrilloSalidaR=BD_AccesoDatos.obtenerCuyesLimiteEdadEnPoza("PD","Recría",730,descripcion,context);
        actividadesAll.addAll(activiPadrilloSalidaR);
        List<Actividad> activiPadrilloSalidaE=BD_AccesoDatos.obtenerCuyesLimiteEdadEnPoza("PD","Empadre",730,descripcion,context);
        actividadesAll.addAll(activiPadrilloSalidaE);
        List<Actividad> activiPadrilloSalidaP=BD_AccesoDatos.obtenerCuyesLimiteEdadEnPoza("PD","Parillo",730,descripcion,context);
        actividadesAll.addAll(activiPadrilloSalidaP);

    }
    private void retiro_de_engorde()
    {

    }

    public List<Actividad> getActividadesAll() {
        return actividadesAll;
    }

    public void setActividadesAll(List<Actividad> actividadesAll) {
        this.actividadesAll = actividadesAll;
    }





}
