package com.example.aboutme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aboutme.databinding.FragmentMessageBinding;


public class MessageFragment extends Fragment {
    private FragmentMessageBinding mBinding;

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentMessageBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.btContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.btContact.setVisibility(View.GONE);
                mBinding.messageHolder.setVisibility(View.VISIBLE);
                mBinding.btEnvmsg.setVisibility(View.VISIBLE);
            }
        });

        mBinding.btEnvmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.msgText.getText().toString().length() != 0) {
                    String message = mBinding.msgText.getText().toString();
                    sendMessage(message);
                } else {
                    Toast.makeText(getContext(), "Debes ingresar un mensaje", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendMessage(String message) {
        Intent mIntent = new Intent(Intent.ACTION_SENDTO);
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL, "garcyv@gmail.com");
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Prueba envio");
        mIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(mIntent);
    }
}