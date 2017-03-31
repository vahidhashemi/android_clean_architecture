package com.vahidhashemi.test_mvp.injector.module;

import android.app.Application;

import com.google.gson.Gson;
import com.vahidhashemi.repo.DBRepository;
import com.vahidhashemi.test_mvp.App;
import com.vahidhashemi.test_mvp.injector.scope.PerApplication;
import com.vahidhashemi.test_mvp.repo.FileRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@PerApplication
@Module
public class ApplicationModule {

    App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    public Application application(){
        return application;
    }

    @Provides
    public App app() {
        return application;
    }

    @Provides
    public DBRepository fileRepository(Gson gson){
        return new FileRepositoryImpl(gson, application);
    }

    @Provides
    public Gson gson() {
        return new Gson();
    }
}
