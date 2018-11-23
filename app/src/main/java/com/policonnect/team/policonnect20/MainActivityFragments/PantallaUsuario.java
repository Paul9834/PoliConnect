package com.policonnect.team.policonnect20.MainActivityFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.R;
import com.policonnect.team.policonnect20.UserScreens.UsuarioHorario;
import com.policonnect.team.policonnect20.UserScreens.UsuarioNotas;

/**
 * @version 1
 * @author: PoliConnect Team
 */
public class PantallaUsuario extends Fragment {

    private ImageButton mGrades;
    private ImageButton mSchedule;
    private static TextView mUsername;
    private static TextView mUserCode;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pantalla_usuario, container, false);

        setViews(view);
        setButtonsListeners();

        setUserData();
        return view;
    }

    public  static  void setUserData(){
        mUsername.setText(DataBase.getStudentName());
        mUserCode.setText(DataBase.getStudentCode());
    }


    private void setViews(View view) {
        mGrades = view.findViewById(R.id.noteButton);
        mSchedule = view.findViewById(R.id.scheduleButton);
        mUsername = view.findViewById(R.id.username);
        mUserCode = view.findViewById(R.id.codeUser);
    }

    private void setButtonsListeners() {
        mGrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UsuarioNotas.class);
                startActivity(i);
            }
        });
        mSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UsuarioHorario.class);
                startActivity(i);
            }
        });
    }
}
