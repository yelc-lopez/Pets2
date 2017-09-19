package com.yelc.lopez.pets.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.yelc.lopez.pets.R;
import com.yelc.lopez.pets.adapters.adapterServiciosCard;
import com.yelc.lopez.pets.models.modelTarjeta;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    private RecyclerView listaRecycler;

    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        listaRecycler = (RecyclerView) view.findViewById(R.id.listaRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaRecycler.setLayoutManager(linearLayoutManager);


        adapterServiciosCard adapterServiciosCard = new adapterServiciosCard(tarjetas(),R.layout.card_servicios,getActivity());


        listaRecycler.setAdapter(adapterServiciosCard);


        return view;



    }


    public static ServicesFragment newInstance(int sectionNumber) {
        ServicesFragment fragment = new ServicesFragment();
        Bundle args = new Bundle();
        args.putInt("pantalla No: ", sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    public ArrayList<modelTarjeta> tarjetas(){
        ArrayList<modelTarjeta> lista = new ArrayList<>();
        lista.add(new modelTarjeta(getResources().getDrawable(R.drawable.etologia),"Etologia","Si tu mascota es agresiva, demasiado inquieta, nerviosa o si todos los días destruye algo dentro del hogar, se orina o defeca en medio de tu sala o arriba del colchón, tal vez tiene un problema. De acuerdo con la Facultad de Medicina Veterinaria y Zootecnia de la UNAM, la etología es un nuevo campo de especialidad en la medicina veterinaria, el cual se encarga de la prevención, diagnóstico y tratamiento de los problemas de comportamiento en perros y gatos. "));
        lista.add(new modelTarjeta(getResources().getDrawable(R.drawable.gimnasio),"Gimnasio","Nuestras mascotas necesitan ejercitarse y gastar la energía con la que nos reciben y celebran con nosotros. Sobre todo los animales de gran tamaño, como ciertas razas de perros, requieren de una rutina intensa de ejercicios para prevenir problemas cardiacos, en sus articulaciones y en los huesos; así como problemas emocionales, como la depresión y la estereotipia, que son esas acciones compulsivas que tu mascota realiza muchas veces para llamar la atención o porque está nerviosa.\n" +
                "\n" +
                "En la Ciudad de México existen diversas opciones a las que puedes acudir para que tu mascota haga la actividad física que necesita para estar tranquilo y feliz cuando ambos están en casa. Bravo Perro Fitness es un gimnasio ubicado al sur de la Ciudad de México en el que los perros podrán ejercitarse y llevar a cabo actividades que alienten sus capacidades físicas y sensoriales, con instalaciones especialmente diseñadas para que tu mascota libere toda la energía y juegue con adiestradores especializados."));
        lista.add(new modelTarjeta(getResources().getDrawable(R.drawable.guarderia),"Guarderia","Las largas jornadas laborales hacen que no podamos estar todo el tiempo que quisiéramos con nuestras mascotas. En muchas ocasiones, dejar a tu mascota sola en casa no es una opción, ya sea por su tamaño, porque es muy inquieto o porque tiene algunos problemas de comportamiento que ocasionan que tu casa o departamento luzca como un campo de batalla cuando regresas de trabajar.\n" +
                "\n" +
                "Canino Mondo es una establecimiento ubicado en la colonia Progreso, en la Ciudad, que ofrece los servicios de guardería y hotel para tu perro, en donde el animal convivirá con otros animalitos a la vez que es vigilado y atendido por personas capacitadas. Tumascota es también una buena opción que se encuentra ubicada en la colonia San Pedro de los Pinos y en donde tu mascota estará bajo el cuidado de personas que buscan establecer una relación tanto entre los animales como entre sus dueños. "));
        lista.add(new modelTarjeta(getResources().getDrawable(R.drawable.hotel),"Hotel o Pensión","¿Necesitas salir de viaje y no sabes con quién dejar a tu mascota? Un hotel o una pensión canina es la mejor opción para ti. Un hotel o pensión canina es un lugar con las instalaciones y el personal adecuado para que tu mascota se sienta como en casa mientras tú no estás. Verifica que el hotel o pensión de tu elección cuente con espacios abiertos en los que tu mascota pueda convivir con otros animales; lugares de descanso limpios y amplios; así como con veterinarios y personal capacitado para atender a tu mascota.\n" +
                "\n" +
                "Los precios y beneficios de este tipo de lugares varían dependiendo de su ubicación y de los servicios que ofrecen. Nuugi Resort es un hotel de lujo para mascotas, con 100 habitaciones para perros y 14 para gatos ubicado en Interlomas, en la Ciudad de México. Otra opción es El Can Contento, el cual se encuentra a unos minutos de la Ciudad de México y cuenta con grandes espacios abiertos para que tu mascota corra y juegue con otros animalitos."));
        lista.add(new modelTarjeta(getResources().getDrawable(R.drawable.spa),"Estetica y Spa","También nuestras mascotas pueden sufrir estrés, depresión o nerviosismo. Además de ejercitarse, puedes optar por otras opciones de tratamiento para que tu perro o gato esté lo más tranquilo posible. Un spa para mascotas es un lugar en el que puedes llevar a tu animalito a que reciba un masaje o un baño reconfortante. También, hay muchos de estos establecimientos que cuentan con estética canina, en donde bañarán a tu mascota, le cortarán las uñas, le lavarán los dientes y las glándulas (grooming), además de que le harán el corte de pelo que esté de moda en ese momento.\n" +
                "\n" +
                "Tanto Pet Central como Spa-Pet son establecimientos ubicados en las colonias Condesa y Roma, respectivamente, en los que puedes llevar a tu perro a disfrutar de un masaje o de un delicioso baño con sales y aceites hidratantes, además de música ambiental, para que salga con el pelo brillante y con una actitud relajada. "));
        lista.add(new modelTarjeta(getResources().getDrawable(R.drawable.restaurante),"Restaurante","Algunas colonias dentro de la Ciudad de México se caracterizan porque en ellas hay muchos lugares con la categoría Pet Friendly (Amigable con las mascotas) entre los servicios que ofrecen. Entre este tipo de establecimientos existen algunos que se dedican sobre todo a consentir a tu mascota mientras tú disfrutas de un refrigerio o un café; los restaurantes especializados en comida para mascotas están teniendo cierto éxito entre las personas que disfrutan de la compañía de su mascota en todo momento.\n" +
                "\n" +
                "Bow Wow Deli es un café/restaurante en el que tanto las personas como los perros pueden disfrutar de comida y café gourmet y en el que tu mascota será consentida incluso más que tú. También existen otras opciones, como Dogkery, que es una pastelería especializada en postres y pasteles para perros y gatos, como helados de pollo y tocino y hasta pizzas para tu canino amigo."));
        return lista;
    }

}
