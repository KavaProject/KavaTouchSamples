package org.kavaproject.kavatouch.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.kavaproject.kavatouch.foundation.*;
import org.kavaproject.kavatouch.runtime.*;

import javax.inject.Singleton;

public class RuntimeGuiceModule extends RuntimeModule implements Module {
    @Override
    public void configure(Binder binder) {
    }

    @Override
    @Provides
    @Singleton
    public FactoryRegistry provideFactoryRegistry() {
        return super.provideFactoryRegistry();
    }

    @Override
    @Provides
    @Singleton
    public FactoryService provideFactoryService(FactoryRegistry factoryRegistry) {
        return super.provideFactoryService(factoryRegistry);
    }

    @Override
    @Provides
    @Singleton
    public MethodResolver provideMethodResolver(FactoryRegistry factoryRegistry) {
        return super.provideMethodResolver(factoryRegistry);
    }

    @Override
    @Provides
    @Singleton
    public MethodPerformer provideMethodPerformer(InvocationFactory invocationFactory, TimerFactory timerFactory, FoundationDateFactory foundationDateFactory, RunLoopFactory runLoopFactory, MethodDispatcher methodDispatcher, MethodSignatureService methodSignatureService) {
        return super.provideMethodPerformer(invocationFactory, timerFactory, foundationDateFactory, runLoopFactory,
                methodDispatcher, methodSignatureService);
    }

    @Override
    @Provides
    @Singleton
    public MethodDispatcher provideMethodDispatcher(MethodResolver methodRegistry, FactoryRegistry factoryRegistry,
                                                    FoundationExceptionFactory foundationExceptionFactory,
                                                    MethodSignatureFactory methodSignatureFactory) {
        return super.provideMethodDispatcher(methodRegistry, factoryRegistry, foundationExceptionFactory,
                methodSignatureFactory);
    }

    @Override
    @Provides
    @Singleton
    public MethodSignatureService provideMethodSignatureService(MethodResolver methodResolver, MethodSignatureFactory methodSignatureFactory) {
        return super.provideMethodSignatureService(methodResolver, methodSignatureFactory);
    }

    @Override
    @Provides
    @Singleton
    public MethodBackgroundPerformer provideMethodBackgroundPerformer(FoundationThreadFactory foundationThreadFactory) {
        return super.provideMethodBackgroundPerformer(foundationThreadFactory);
    }
}
