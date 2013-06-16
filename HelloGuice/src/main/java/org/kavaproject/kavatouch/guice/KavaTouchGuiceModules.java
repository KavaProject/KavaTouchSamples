package org.kavaproject.kavatouch.guice;

import com.google.inject.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class KavaTouchGuiceModules {
    public static final List<Module> ALL = Arrays.asList(new CoreAnimationGuiceModule(), new FoundationGuiceModule(),
            new InternalGuiceModule(), new RuntimeGuiceModule(), new UIKitGuiceModule());

    public static final List<Module> union(Module... modules) {
        ArrayList<Module> res = new ArrayList<Module>(ALL);
        res.addAll(Arrays.asList(modules));
        return res;
    }
}
