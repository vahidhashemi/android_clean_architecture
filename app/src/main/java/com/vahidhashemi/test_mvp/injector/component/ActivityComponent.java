package com.vahidhashemi.test_mvp.injector.component;

import com.vahidhashemi.test_mvp.activity.MainActivity;
import com.vahidhashemi.test_mvp.injector.module.CarModule;
import com.vahidhashemi.test_mvp.injector.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = CarModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
