package com.egzepsn.rsc.rscapp.modules.main.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.egzepsn.rsc.rscapp.R;
import com.egzepsn.rsc.rscapp.app.RSCApp;
import com.egzepsn.rsc.rscapp.commons.activity.view.ActivityView;
import com.egzepsn.rsc.rscapp.commons.fragment.BaseFragment;
import com.egzepsn.rsc.rscapp.enums.AppStateEnum;
import com.egzepsn.rsc.rscapp.modules.main.MainActivity;
import com.egzepsn.rsc.rscapp.modules.main.home.view.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import retrofit2.http.Body;


public class HomeFragment extends BaseFragment implements HomeView {

    @BindView(R.id.btn_signalr_send)
    Button btnSignalRSend;

    @BindView(R.id.etSignalRMessage)
    EditText etSignalRMessage;

    //private HomePresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewInflater = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, viewInflater);


        //presenter = new HomePresenterImpl(this);

        //((ActivityView) getContext()).showTitle(getContext().getString(R.string.btn_login));
        RSCApp.getInstance().setAppState(AppStateEnum.SignedIn);

        setupSignalR();


        return viewInflater;
    }

    private void setupSignalR() {
        //Platform.loadPlatformComponent(new AndroidPlatformComponent());

    }

    @OnClick(R.id.btn_signalr_send)
    public void sendMessage(){
        ((MainActivity)getActivity()).sendMessage(etSignalRMessage.getText().toString());
    }
}