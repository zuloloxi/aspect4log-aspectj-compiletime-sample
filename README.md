# aspect4log-aspectj-compiletime-sample
Sample project for  apsect4log framework, demonstrates pure aspectj approach

Build jar aspect4log-aspectj-compile-time-sample-1.0.X.jar file with :

    mvn clean install

Now place @Log annotation on any class, method or constructor and launch your application.

## Quick Start with AspectJ
AspectJ is fast, mature and powerful AOP extension for java. We strongly recommend to use it with aspect4log even if the rest of your application is using SpringAOP.

The benefits of using it over SpringAOP are the following:

AspectJ is easier to configure.
AspectJ does not require dependencies on Spring Framework (This should be your AOP framework of choice in case you don't use Spring)
AspectJ allows you to use @Log annotation on any class (while SpringAOP deals only with spring-managed beans).
AspectJ does not create proxy objects, thus makes the execution faster and with less memory consumptions.
@Log annotation will work with constructors.
@Log annotation will work with all method visibilities levels (while SpringAOP can work only with public).

## http://aspect4log.sourceforge.net/quick-start-aspectj.html
