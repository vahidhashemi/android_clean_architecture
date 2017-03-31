package com.vahidhashemi.test_mvp;

import android.app.Application;

import com.vahidhashemi.test_mvp.injector.component.ApplicationComponent;
import com.vahidhashemi.test_mvp.injector.component.DaggerApplicationComponent;
import com.vahidhashemi.test_mvp.injector.module.ApplicationModule;

public class App extends Application {

    ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


}
