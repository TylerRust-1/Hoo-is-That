package com.example.hooisthat.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> audioText;


    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is settings fragment");

        audioText = new MutableLiveData<>();
        audioText.setValue("5");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getAudioDuration() {
        return audioText;
    }
}