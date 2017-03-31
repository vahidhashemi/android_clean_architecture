package com.vahidhashemi.test_mvp.injector.component;

import com.vahidhashemi.repo.DBRepository;
import com.vahidhashemi.test_mvp.injector.module.ApplicationModule;
import com.vahidhashemi.test_mvp.injector.scope.PerApplication;

import dagger.Component;

@Component(modules = ApplicationModule.class)
@PerApplication
public interface ApplicationComponent {
    DBRepository fileRepository();
}
