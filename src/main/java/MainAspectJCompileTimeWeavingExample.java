

import org.foo.serivce.FooService;

public class MainAspectJCompileTimeWeavingExample {
	public static void main(String[] args) {
		FooService fooService = new FooService("foo");
		fooService.helloDefaultLogging("John Snow",FooService.Gender.MALE);
		fooService.helloCustomizedTemplate("John Snow",FooService.Gender.MALE);
		fooService.helloCustomizedLogLevel("John Snow",FooService.Gender.MALE);
		fooService.helloMdc("John Snow",FooService.Gender.MALE);
		try {
			fooService.helloDifferentLogLevelForExceptions("John",FooService.Gender.MALE);
		} catch (IllegalArgumentException e) {
			//
		}
		
		try {
			fooService.helloDifferentLogLevelForExceptions(null,FooService.Gender.MALE);
		} catch (NullPointerException e) {
			//
		}
		
	}
}
