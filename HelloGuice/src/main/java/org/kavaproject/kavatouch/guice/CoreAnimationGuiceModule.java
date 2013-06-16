package org.kavaproject.kavatouch.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.kavaproject.kavatouch.coreanimation.AnimationLayerFactory;
import org.kavaproject.kavatouch.coreanimation.CoreAnimationModule;
import org.kavaproject.kavatouch.uikit.UIColorFactory;

import javax.inject.Singleton;

public class CoreAnimationGuiceModule extends CoreAnimationModule implements Module {
    @Override
    @Provides
    @Singleton
    public AnimationLayerFactory provideAnimationLayerFactory(UIColorFactory uiColorFactory) {
        return super.provideAnimationLayerFactory(uiColorFactory);
    }

    @Override
    public void configure(Binder binder) {
    }
}
