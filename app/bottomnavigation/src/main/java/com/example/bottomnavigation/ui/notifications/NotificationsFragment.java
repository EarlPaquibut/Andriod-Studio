package com.example.bottomnavigation.ui.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView textView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textNotifications;
        final Button btnBattery = binding.btnBattery;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(),textView::setText);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        btnBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().registerReceiver(broadcastreceiver, intentFilter);
            }
        });
        return root;
    }

    private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
                    if(deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD)
                    {
                        textView.setText("currentBatteryHealth"+" = GOOD");
                    }
            if(deviceHealth == BatteryManager.BATTERY_HEALTH_COLD)
            {
                textView.setText("currentBatteryHealth"+" = COLD");
            }
            if(deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD)
            {
                textView.setText("currentBatteryHealth"+" = DEAD");
            }
            if(deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT)
            {
                textView.setText("currentBatteryHealth"+" = OVERHEAT");
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}