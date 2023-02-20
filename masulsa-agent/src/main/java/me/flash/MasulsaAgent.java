package me.flash;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MasulsaAgent {

    public static void premain(String arguments, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(
                        (builder, typeDescription, classLoader, module, protectionDomain)
                                -> builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                ).installOn(instrumentation);
    }
}
