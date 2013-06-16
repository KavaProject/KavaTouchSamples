package org.kavaproject.kavatouch.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.kavaproject.kavatouch.foundation.*;
import org.kavaproject.kavatouch.runtime.MethodDispatcher;
import org.kavaproject.kavatouch.runtime.MethodPerformer;
import org.kavaproject.kavatouch.runtime.MethodSignatureService;

import javax.inject.Singleton;

public class FoundationGuiceModule extends FoundationModule implements Module {
    @Override
    public void configure(Binder binder) {
    }

    @Override
    @Provides
    @Singleton
    public AttributedStringFactory provideAttributedStringFactory() {
        return super.provideAttributedStringFactory();
    }

    @Override
    @Provides
    @Singleton
    public BlockOperationFactory provideBlockOperationFactory() {
        return super.provideBlockOperationFactory();
    }

    @Override
    @Provides
    @Singleton
    public BundleFactory provideBundleFactory(URLFactory urlFactory) {
        return super.provideBundleFactory(urlFactory);
    }

    @Override
    @Provides
    @Singleton
    public FoundationDateFactory provideFoundationDateFactory() {
        return super.provideFoundationDateFactory();
    }

    @Override
    @Provides
    @Singleton
    public FoundationErrorFactory provideFoundationErrorFactory() {
        return super.provideFoundationErrorFactory();
    }

    @Override
    @Provides
    @Singleton
    public FoundationExceptionFactory provideFoundationExceptionFactory() {
        return super.provideFoundationExceptionFactory();
    }

    @Override
    @Provides
    @Singleton
    public FoundationStringFactory provideFoundationStringFactory() {
        return super.provideFoundationStringFactory();
    }

    @Override
    @Provides
    @Singleton
    public FoundationThreadFactory provideFoundationThreadFactory(MethodPerformer methodPerformer) {
        return super.provideFoundationThreadFactory(methodPerformer);
    }

    @Override
    @Provides
    @Singleton
    public InvocationFactory provideInvocationFactory(MethodDispatcher methodDispatcher) {
        return super.provideInvocationFactory(methodDispatcher);
    }

    @Override
    @Provides
    @Singleton
    public InvocationOperationFactory provideInvocationOperationFactory() {
        return super.provideInvocationOperationFactory();
    }

    @Override
    @Provides
    @Singleton
    public KeyedArchiverFactory provideKeyedArchiverFactory() {
        return super.provideKeyedArchiverFactory();
    }

    @Override
    @Provides
    @Singleton
    public KeyedUnarchiverFactory provideKeyedUnarchiverFactory() {
        return super.provideKeyedUnarchiverFactory();
    }

    @Override
    @Provides
    @Singleton
    public MachPortFactory provideMachPortFactory(PortMessageFactory portMessageFactory) {
        return super.provideMachPortFactory(portMessageFactory);
    }

    @Override
    @Provides
    @Singleton
    public MessagePortNameServer provideSharedMessagePortNameServer() {
        return super.provideSharedMessagePortNameServer();
    }

    @Override
    @Provides
    @Singleton
    public MethodSignatureFactory provideMethodSignatureFactory() {
        return super.provideMethodSignatureFactory();
    }

    @Override
    @Provides
    @Singleton
    public NotificationCenterFactory provideNotificationCenterFactory() {
        return super.provideNotificationCenterFactory();
    }

    @Override
    @Provides
    @Singleton
    public NotificationFactory provideNotificationFactory() {
        return super.provideNotificationFactory();
    }

    @Override
    @Provides
    @Singleton
    public NotificationQueueFactory provideNotificationQueueFactory() {
        return super.provideNotificationQueueFactory();
    }

    @Override
    @Provides
    @Singleton
    public OperationQueueFactory provideOperationQueueFactory() {
        return super.provideOperationQueueFactory();
    }

    @Override
    @Provides
    @Singleton
    public PortMessageFactory providePortMessageFactory() {
        return super.providePortMessageFactory();
    }

    @Override
    @Provides
    @Singleton
    public PortNameServer provideSystemDefaultPortNameServer() {
        return super.provideSystemDefaultPortNameServer();
    }

    @Override
    @Provides
    @Singleton
    public ProcessInfo provideProcessInfo() {
        return super.provideProcessInfo();
    }

    @Override
    @Provides
    @Singleton
    public PropertyListSerializationFactory providePropertyListSerializationFactory() {
        return super.providePropertyListSerializationFactory();
    }

    @Override
    @Provides
    @Singleton
    public RunLoopFactory provideRunLoopFactory(FoundationDateFactory foundationDateFactory) {
        return super.provideRunLoopFactory(foundationDateFactory);
    }

    @Override
    @Provides
    @Singleton
    public TimerFactory provideTimerFactory(FoundationDateFactory foundationDateFactory,
                                            RunLoopFactory runLoopFactory, InvocationFactory invocationFactory,
                                            MethodSignatureService methodSignatureService) {
        return super.provideTimerFactory(foundationDateFactory, runLoopFactory, invocationFactory,
                methodSignatureService);
    }

    @Override
    @Provides
    @Singleton
    public URLFactory provideURLFactory() {
        return super.provideURLFactory();
    }

    @Override
    @Provides
    @Singleton
    public NotificationCenter provideDefaultNotificationCenter(NotificationCenterFactory notificationCenterFactory) {
        return super.provideDefaultNotificationCenter(notificationCenterFactory);
    }
}
